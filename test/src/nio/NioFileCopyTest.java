package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioFileCopyTest {
	public static void main(String[] args) throws IOException {
		//FileInputStream fis = new FileInputStream("D:\\testnio.txt");
		//FileOutputStream fos = new FileOutputStream("D:\\testniocopy.txt");
		
		RandomAccessFile rafi = new RandomAccessFile("D:\\testnio.txt", "rw");
		RandomAccessFile rafo = new RandomAccessFile("D:\\testniocopy2.txt", "rw");
		
		FileChannel fci = rafi.getChannel();
		FileChannel fco = rafo.getChannel();
		
        ByteBuffer buf = ByteBuffer.allocate(1024);

        while (fci.read(buf) != -1) {
            buf.flip();
            fco.write(buf);
            buf.clear();
        }
        
        rafi.close();
        rafo.close();
	}
}
