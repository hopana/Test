package nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;
import java.util.UUID;

public class CreateData {
	public static void main(String[] args) throws IOException {
		writeData();
	}

	public static String getKey() {
		Random random = new Random();

		char[] alphabet = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

		String key = "";

		for (int i = 0; i < 8; i++) {
			int n = random.nextInt(36);
			key += alphabet[n];
		}
		
		if (key.endsWith("0")) {
			key = key.substring(0, key.length() - 1);
		}
		
		return key;
	}

	public static String getValue() {
		String value = UUID.randomUUID().toString().replaceAll("-", "");
		
		if (value.startsWith("0")) {
			value = value.substring(1);
		}
		
		return value;
	}

	public static void writeData() throws IOException {
		File file = new File("src/nio/big.data");
		RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
		FileChannel channel = randomAccessFile.getChannel();
		channel.position(channel.size());
		
		String key = "";
		String value = "";
		String content = "";
		for (int i = 0; i < 3500000; i++) {
			key = getKey();
			value = getValue();

			content = key + "," + value + "\n";
			ByteBuffer buf = ByteBuffer.wrap(content.getBytes());
			buf.put(content.getBytes());
			buf.flip();
			channel.write(buf);
		}

		randomAccessFile.close();
	}
}
