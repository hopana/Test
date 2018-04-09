package number;

public class ObjectToLong {
	public static void main(String[] args) {
		Object o = 100;
		System.out.println(Long.valueOf(o.toString()));
	}
}
