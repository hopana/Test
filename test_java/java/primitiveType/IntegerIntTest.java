package primitiveType;

public class IntegerIntTest {
	public static void main(String[] args) {
		Integer a =  10;
		int b = 10;
		Integer c = new Integer(10);
		
		System.out.println(a == b);
		System.out.println(b == c);
		System.out.println(a == c);
		
	}
}
