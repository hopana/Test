package test;

public class PrintTest {
	public static void print(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}

	public static void main(String[] args) {
		print(4);
	}
}
