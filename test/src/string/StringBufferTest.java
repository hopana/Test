package string;

public class StringBufferTest {
	public static void main(String[] args) {
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		
		sb1.append("hello ");
		sb2.append("world ");
		
		System.out.println(sb1.append(sb2).toString());
	}
}
