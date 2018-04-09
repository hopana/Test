package syntax;

public class TryCatchTest {
    public static void main(String[] args) {
        int i = 0;
        try {
            int n = 5 / i;
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("出现异常不影响异常语句后面的代码执行...........");
    }
}
