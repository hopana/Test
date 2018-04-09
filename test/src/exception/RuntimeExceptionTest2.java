package exception;

public class RuntimeExceptionTest2 {
	public static void main(String[] args) {
		try {
			TestClass22.test2();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("main方法。。。。。。");
	}
}

class TestClass21 {
	public static void test1() {
		System.out.println("方法test1被执行......");
		throw new RuntimeException();
	}
}

class TestClass22 {
	public static void test2() {
		TestClass21.test1();
		System.out.println("方法test2被执行......");
	}
}