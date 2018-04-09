package syntax;

public class NullPointerTest {
    public static void main(String[] args) {
        int[] a = null;
        if (0 != a.length) {
            System.out.println("a不为空");
        }
    }
}
