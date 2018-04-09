package syntax;

public class FinallyTest {
    public static void main(String[] args) {
        try {
            System.out.println("aaa");
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("bbb");
        }
    }
}
