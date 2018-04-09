package exception;

public class RuntimeExceptionTest1 {
	public static void main(String[] args) {
		TestClass12.test2();
		System.out.println("main方法。。。。。。");
	}
}

class TestClass11 {
	public static void test1() {
		System.out.println("方法test1被执行......");
		throw new RuntimeException();
	}
}

class TestClass12 {
	public static void test2() {
		TestClass11.test1();
		System.out.println("方法test2被执行......");
	}
}