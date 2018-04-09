package syntax;

public class StaticTest {
    public static String name = "Mike";

    public static void test() {
        System.out.println("static method");
        System.out.println(name);
    }

    static {
        System.out.println("static block");
        System.out.println(name);
    }

    public StaticTest() {
        System.out.println("Constuctor method");
    }

    public static void main(String[] args) {
        StaticTest st = new StaticTest();
        st.test();
    }
}
