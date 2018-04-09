package syntax;

public class DefaultValueOfString {
    public static void main(String[] args) {
        FooTest foo = new FooTest();
        foo.print();
    }

}

class FooTest {
    static String s1;
    String s2;

    public void print() {
        System.out.println(s1);
        System.out.println(s2);
    }
}