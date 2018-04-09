package test;

public class Test1 {
	public static void main(String[] args) {
		int count = 1;
		count+=count++;
		//count = count + count++;
		System.out.println(count);
	}
}
