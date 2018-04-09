package fileoper;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器类
 *
 * 1、创建ServerSocket对象，绑定监听端口
 * 2、通过accept()方法监听客户端请求
 * 3、连接建立后，通过输入流读取客户端发送的请求信息
 * 4、通过输出流向客户端发送响应信息
 * 5、关闭相关资源
 * 
 */
public class Server {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ServerSocket server = null;
		Socket socket = null;
		// 读取本机文件的流
		InputStream is = null;
		// 输出流对象
		OutputStream os = null;
		try {
			// 1、创建ServerSocket对象，绑定监听端口
			server = new ServerSocket(7995);
			// 2、通过accept()方法监听客户端请求
			socket = server.accept();
			// System.out.println( socket.getLocalAddress().getHostAddress());

			// 3、连接建立后，通过输入流读取客户端发送的请求信息
			os = socket.getOutputStream();
			// 读取本机文件
			is = new FileInputStream("D:\\welcome.txt");
			// 定义临时存储文件读取类容的块
			byte[] buffer = new byte[1024];
			// 定义读取的真实长度值
			int len = 0;
			// 将文件内容写入到网络中
			while ((len = is.read(buffer)) != -1) {
				os.write(buffer, 0, len);
			}

			// 清楚缓冲区的内容，关闭文件读取对象，释放内存占用资源
			os.flush();
			os.close();
			is.close();
			// 关闭通信对象
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
