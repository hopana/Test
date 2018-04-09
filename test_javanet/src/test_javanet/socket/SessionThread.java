package test_javanet.socket;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SessionThread extends Thread {

	private Socket socket = null;

	public SessionThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		// super.run();
		OutputStream os = null;
		InputStream is = null;

		try {
			is = new FileInputStream("c:\\welcome.txt");
			os = socket.getOutputStream();

			byte[] buffer = new byte[1024];
			int len = 0;

			while ((len = is.read(buffer)) != -1) {
				os.write(buffer, 0, len);
			}

			os.flush();
			os.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
