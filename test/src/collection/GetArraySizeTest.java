package collection;

import java.lang.reflect.Array;

public class GetArraySizeTest {
	public static void main(String[] args) {
		int[] a = new int[0];
		
		System.out.println(Array.getLength(a));
		System.out.println(Array.getLength(null));
	}
}
