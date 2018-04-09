package test_javanet.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		ServerSocket server = null;
		Socket socket = null;
		try {
			server = new ServerSocket(7995);
			while (true) {
				socket = server.accept();
				System.out.println("地址:" + socket.getInetAddress().getHostAddress());

				SessionThread st = new SessionThread(socket);
				st.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
