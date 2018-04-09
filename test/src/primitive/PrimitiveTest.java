package primitive;

public class PrimitiveTest {
	public static void main(String[] args) {
		String a = "1";
		Integer b = 2;
		Boolean f = true;
		
		System.out.println(a.getClass().isPrimitive());
		System.out.println(b.getClass().isPrimitive());
		System.out.println(f.getClass().isPrimitive());
	}
}
