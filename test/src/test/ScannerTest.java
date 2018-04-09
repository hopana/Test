package test;

import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] args) {
		String s = "hello world!";
		Scanner scan = new Scanner(s);
		scan.useDelimiter("l");
		
		while (scan.hasNext()) {
			System.out.print(scan.next());
		}
		
		scan.close();
		scan = null;
	}
}
