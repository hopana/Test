package test;

public class StringBufferInsertTest {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("select * from dual");
		sb.insert(0, "select * from (");
		sb.insert(sb.length(), ") where xx > 0");
		
		System.out.println(sb.toString());
	}
}
