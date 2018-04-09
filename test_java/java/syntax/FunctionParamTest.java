package syntax;

public class FunctionParamTest {
    public static void test(Object o) {
        System.out.println("I'm object!");
    }

    public static void test(String s) {
        System.out.println("I'm object!");
    }

    public static void main(String[] args) {
        test(null);
    }

}
