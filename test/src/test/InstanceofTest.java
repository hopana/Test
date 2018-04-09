package test;

public class InstanceofTest {
	
	public static void test(Object o) {
		if (o instanceof Object[]) {
			System.out.println("instanceof Object[]");
		} 
		if (o.getClass().isArray()) {
			System.out.println("isArray");
		}
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{1, 2, 3};
		test(a);
	}
}
