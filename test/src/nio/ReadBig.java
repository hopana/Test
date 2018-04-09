package nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * NIO内存映射读大文件
 * @author HP
 */
public class ReadBig {
	public static void main(String[] args) {

		final int BUFFER_SIZE = 0x300000;// 缓冲区大小为3M
		File file = new File("E:\\迅雷下载\\[电影天堂www.dy2018.com]超脑48小时HD高清国英双语中字.mkv");

		/**
		 * map(FileChannel.MapMode mode, long position, long size)
		 * mode - 根据是按只读、读取/写入或专用（写入时拷贝）来映射文件，分别为 FileChannel.MapMode
		 * 类中所定义的READ_ONLY、READ_WRITE 或 PRIVATE 之一
		 * position - 文件中的位置，映射区域从此位置开始；必须为非负数
		 * size - 要映射的区域大小；必须为非负数且不大于 Integer.MAX_VALUE
		 * 所以若想读取文件后半部分内容，如例子所写；若想读取文本后1/8内容，需要这样写map(FileChannel.MapMode.READ_ONLY, f.length()*7/8,f.length()/8)
		 * 想读取文件所有内容，需要这样写map(FileChannel.MapMode.READ_ONLY, 0,f.length())
		 */

		RandomAccessFile randomAccessFile = null;

		try {
			randomAccessFile = new RandomAccessFile(file, "r");
			FileChannel channel = randomAccessFile.getChannel();
			MappedByteBuffer inputBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());

			byte[] dst = new byte[BUFFER_SIZE];// 每次读出3M的内容
			long start = System.currentTimeMillis();

			for (int offset = 0; offset < inputBuffer.capacity(); offset += BUFFER_SIZE) {
				if (inputBuffer.capacity() - offset >= BUFFER_SIZE) {
					for (int i = 0; i < BUFFER_SIZE; i++)
						dst[i] = inputBuffer.get(offset + i);
				} else {
					for (int i = 0; i < inputBuffer.capacity() - offset; i++)
						dst[i] = inputBuffer.get(offset + i);
				}

				int capacity = inputBuffer.capacity();
				int length = (capacity % BUFFER_SIZE == 0) ? BUFFER_SIZE : capacity % BUFFER_SIZE;
				System.out.println(new String(dst, 0, length));
				// new String(dst,0,length)这样可以取出缓存保存的字符串，可以对其进行操作
			}

			long end = System.currentTimeMillis();
			System.out.println("读取文件内容花费：" + (end - start) + "毫秒");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				randomAccessFile.close();
				randomAccessFile = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}