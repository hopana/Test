package syntax;

public class ReturnTest4 {
    public static void main(String[] args) {
        FooFoo f = new FooFoo();
        int t = f.test();
        System.out.println(t);
        System.out.println(f.i);
    }
}


class FooFoo {
    int i = 1;

    int test() {
        try {
            System.out.println("try里面的i : " + i);
            return i;
        } finally {
            System.out.println("进入finally...");
            ++i;
            System.out.println("fianlly里面的i : " + i);
        }
    }
}

