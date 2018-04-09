package function;

public class ReturnTest {
    public static void main(String[] args) {
        TestClass tc = new TestClass();
        System.out.println(tc.test1());
        System.out.println(tc.test2());
    }
}

class TestClass {

    public int test1() {
        int x = 1;
        try {
            return x;
        } finally {
            ++x;
        }
    }

    public int test2() {
        int x = 1;
        try {
            return x;
        } finally {
            ++x;
            return x;
        }
    }
}