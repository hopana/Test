package test;

public class SplitTest {
	public static void main(String[] args) {
		String[] arr = "dadsfas".split("\\?");
		
		System.out.println(arr.length);
		for(String s : arr) {
			System.out.println(s);
		}
	}
}
