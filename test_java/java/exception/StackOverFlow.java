package exception;

/**
 * 模拟堆栈溢出
 *
 * @author hupan
 * @date 2018/09/13
 */
public class StackOverFlow {
    public static final void main(String[] args) {
        //main(args);
        test(100);
    }

    public static void test(int a) {
        if (a > 0) {
            test(a);
        }
    }
}
