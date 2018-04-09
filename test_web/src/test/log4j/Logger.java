package test.log4j;

import org.apache.log4j.Category;


public class Logger extends Category{

	public Logger(String name) {
		super(name);
	}

	public void error(Object msg){
		System.out.println(msg);
	}
	
	public void error(Object msg, Throwable t){
		System.out.println(msg + " ：" + t);
	}
	
	public void info(Object msg){
		System.out.println(msg);
	}
	
	public void info(Object msg, Throwable t){
		System.out.println(msg + " ：" + t);
	}
	
}
