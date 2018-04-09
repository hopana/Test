package exception;

public class RuntimeExceotionTest {
	public static void main(String[] args) {
		System.out.println("main开始执行......");
		
		try {
			if (true) {
				int zero = 0;
				int i = 1 / zero;
				System.out.println(i);
			}
		} catch (ArithmeticException e) {
			throw new RuntimeException();
		} finally {
			System.out.println("finally语句块被执行......");
		}
	
		System.out.println("main方法执行完成。。。。。。");
	}
}
