package syntax;

public class ReturnTest {

    public static void fun(boolean flag) {

    }

    public void test() {
        try {
            System.out.println("...try block...");
        } catch (Exception e) {
            System.out.println("...catch block...");
            return;
        } finally {
            System.out.println("...finally block...");
        }
    }
}
