package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletTest implements Servlet {


	/**
	 * 该函数用于初始化该servlet，类似于类的构造函数
	 * 该函数只会被调用一次（当用户第一次访问该servlet时被调用）
	 * 
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("servlet init...");

	}
	
	/**
	 * 该函数用于处理业务逻辑， 程序员应当把业务逻辑代码写在这里
	 * 当用户每访问该servlet时该函数都会被调用
	 * request：用户获得客户端（浏览器）的信息
	 * response：用于向客户端（浏览器）返回信息
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		System.out.println("servlet service...");
		
		// 从response中获得PrintWriter
		PrintWriter pw = response.getWriter();
		pw.println("hello world");

	}
	
	/**
	 * 该函数用户销毁servlet实例（释放内存）
	 * 以下情况会调用该函数
	 * 1.reload该servlet（webApps）
	 * 2.关闭应用服务器（比如tomcat）
	 * 3.关机
	 */
	public void destroy() {
		System.out.println("servlet destroy...");
	}

	public ServletConfig getServletConfig() {
		System.out.println("get servlet config...");
		return null;
	}

	public String getServletInfo() {
		System.out.println("get servlet info...");
		return null;
	}

}























