package param;

public class PassByValueTest {
    public static void main(String[] args) {
        Foo f = new Foo();

        int a = 1000;
        f.change(a);

        System.out.println(a);
    }
}

class Foo {
    public void change(int n) {
        n = -999;
    }
}