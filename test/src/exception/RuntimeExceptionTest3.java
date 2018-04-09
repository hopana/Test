package exception;

public class RuntimeExceptionTest3 {
	public static void main(String[] args) {
		TestClass32.test2();
		System.out.println("main方法。。。。。。");
	}
}

class TestClass31 {
	public static void test1() {
		System.out.println("方法test1被执行......");
		throw new RuntimeException();
	}
}

class TestClass32 {
	public static void test2() {
		try {
			TestClass31.test1();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("方法test2被执行......");
	}
}