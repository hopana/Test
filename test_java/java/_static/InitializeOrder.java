package _static;

public class InitializeOrder {
	public static void main(String[] args) {
		DemoSon son = new DemoSon();
	}
}

class DemoFather {
	static String a = "父类静态变量";
	String b = "父类普通变量";
	
	static {
		System.out.println(a);
		System.out.println("父类静态初始化块");
	}
	
	{
		System.out.println(b);
		System.out.println("父类普通初始化块");
	}
	
	
	
	public DemoFather() {
		System.out.println("父类构造函数");
	}
	
}

class DemoSon extends DemoFather {
	static String a = "子类静态变量";
	String b = "子类普通变量";
	
	static {
		System.out.println(a);
		System.out.println("子类静态初始化块");
	}
	
	{
		System.out.println(b);
		System.out.println("子类普通初始化块");
	}
	
	public DemoSon() {
		System.out.println("子类构造函数");
	}
	
}