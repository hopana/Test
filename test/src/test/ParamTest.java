package test;

import java.util.ArrayList;
import java.util.List;

public class ParamTest {

	public static void test(String... params) {
		for (String s : params) {
			System.out.println("param: " + s);
		}
	}
	
	public static void main(String[] args) {
		String[] params = new String[]{"aa", "bb", "cc", "dd"};
		
		test(params);
	}
	
}
