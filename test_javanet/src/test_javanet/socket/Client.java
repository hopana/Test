package test_javanet.socket;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		
		try {
			socket = new Socket("192.168.0.145", 7995);
			is = socket.getInputStream();
			os = new FileOutputStream("C:\\hello.txt");
			
			int len = 0;
			byte[] buffer = new byte[1024];
			
			while ((len = is.read(buffer)) != -1) {
				os.write(buffer, 0, len);
			}
			
			os.flush();
			os.close();
			is.close();
			socket.close();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
