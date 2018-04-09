package nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Notice:
 * <BR> 1. 仅限使用以下package:
 *		java.lang.*, java.io.*, java.math.*, java.text.*, java.util.*
 * <BR> 2. 请勿变更 package名，类名，test()定义。 
 *
 */
public class ReadSmallTest {
	/**
	 * 请在此方法内完成代码，但可以增加自己的私有方法。
	 * 数据文件inputFile的内容格式为一行一条数据，每条数据有2个字段用逗号分隔，第1个字段为排序用的Key，第二个字段为value。
	 * 换行符为'\n'。
	 * 数据内容举例如下:
	 * abe,xmflsflmfmlsmfs
	 * abc,xmlmxlkmffhf
	 * 8fj3l,xxjfluu313ooo11
	 * 
	 * 注意点: 1.本次的测试数据内容都是ASCII字符，无中文汉字.所以不必考虑encoding。
	 *       2.本次的测试数据中,key的最大长度8，value的最大长度32。
	 * 
	 * 排序以key的升序，使用String.compareTo()来比较key的大小。最后排序完成的数据写入outputFile。
	 * @param inputFile 输入文件
	 * @param outputFile 输出文件
	 * @param tempFile 临时文件。处理的数据量大的时候，可能会需要用到临时文件。
	 * @throws Exception
	 */
	public static void test(File inputFile, File outputFile, File tempFile) throws Exception {
		RandomAccessFile randomAccessFile = null;
		final int BUFFER_SIZE = 0x300000;
		
		try {
			randomAccessFile = new RandomAccessFile(inputFile, "r");
			FileChannel channel = randomAccessFile.getChannel();
			MappedByteBuffer inputBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, inputFile.length());

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

	//TODO ====================== YOUR CODE HERE (You can add private method if need) ======================

}