package collection;

public class EmptyArrayTest {
	public static void main(String[] args) {
		String[] arr = new String[0];
		
		for (String s : arr) {
			System.out.println(s);
		}
		
		for (int i=0; i<arr.length; i++) {
			System.out.println(i);
		}
		
		System.out.println(arr.length);
	}
}
