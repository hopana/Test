package hash;

public class HashTest {
	public static void main(String[] args) {
		String s = "hupan";
		int N = 100;

		System.out.println(s.hashCode() % (N - 1));
		System.out.println(s.hashCode() % N);
		System.out.println(s.hashCode() % (N + 1));
	}
}
