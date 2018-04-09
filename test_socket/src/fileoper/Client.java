package fileoper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 客户端类
 *
 * 1、创建Socket对象，指明需要连接的服务器的地址和端口号
 * 2、连接建立后，通过输出流想服务器端发送请求信息
 * 3、通过输入流获取服务器响应的信息
 * 4、关闭响应资源
 */
public class Client {

	public static void main(String[] args) {
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		
		try {
			socket = new Socket("127.0.0.1", 7995);
			is = socket.getInputStream();

			os = new FileOutputStream("D:\\welcomeyou.txt");

			byte[] buffer = new byte[1024];
			int len = 0;

			// 边读取网络数据 边将其写入到磁盘中
			while ((len = is.read(buffer)) != -1) {
				os.write(buffer, 0, len);
			}

			// 关闭流对象 释放资源
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
