package syntax;

public class TryCatchReturnTest {

    public static void main(String[] args) {
        System.out.println(new TryCatchReturnTest().test());
    }

    public int test() {
        int x = 1;
        try {
            return x;
        } finally {
            x++;
        }
    }
}
