package upload2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 文件对象
 * @author wzztestin
 *
 */
public class DownFileAccess implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2518013155676212866L;
	// 写入文件的流
	RandomAccessFile oSavedFile;
	// 开始位置
	long nPos;
	boolean bFirst;
	AtomicLong readySize;

	public DownFileAccess() throws IOException {
		this("", 0, true, new AtomicLong(0));
	}

	/**
	 * 写入文件初始化
	 * @param sName
	 * @param nPos
	 * @throws IOException
	 */
	public DownFileAccess(String sName, long nPos, boolean bFirst, AtomicLong readySize) throws IOException {
		File wfile = new File(sName);
		oSavedFile = new RandomAccessFile(wfile, "rw");
		if (!bFirst) {
			oSavedFile.seek(wfile.length());
		}
		this.nPos = nPos;
		this.bFirst = bFirst;
		this.readySize = readySize;
	}

	/**
	 * 写文件
	 * @param b
	 * @param nStart
	 * @param nLen
	 * @return
	 */
	public synchronized int write(byte[] b, int nStart, int nLen) {
		int n = -1;
		try {
			oSavedFile.write(b, nStart, nLen);
			readySize.getAndAdd(nLen);
			
			//System.out.println("--------------------------" + readySize.get());
			
			n = nLen;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return n;
	}
}
