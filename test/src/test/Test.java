package test;

public class Test {
	public static void main(String[] args) {
		int i = 100;
		int j = 100;
		String s1 = "测试测试测试" + i--;
		String s2 = "测试测试测试" + --j;
		
		System.out.println(s1);
		System.out.println(s2);
	}
}
