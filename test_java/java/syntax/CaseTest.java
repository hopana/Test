package syntax;

public class CaseTest {
	public static void main(String[] args) {
		print(1);
	}
	
	public static void print(int n) {
		switch (n) {
		case 1:
			System.out.println("1");
		case 2:
			System.out.println("2");
		case 3:
			System.out.println("3");
		case 4:
			System.out.println("4");
		case 5:
			System.out.println("5");
		default:
			System.out.println("default");
		}
	}
}
