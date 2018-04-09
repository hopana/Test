package syntax;

public class TestStaticInit {

    static {
        a = 0;
        System.out.println("sataic block");
    }

    static int a = 1;

    static void f() {
        a = 2;
        System.out.println(a);
    }

    public static void main(String[] args) {
        System.out.println(a);
        //f();
    }
}
