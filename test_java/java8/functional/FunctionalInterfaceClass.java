package functional;

/**
 * 函数式接口
 *
 * @author hupan
 * @date 2017-05-14 10:42
 */
public class FunctionalInterfaceClass {

    @FunctionalInterface
    public interface Print {
        void print(String s);
    }

    public static void main(String[] args) {
        Print p = (s) -> {System.out.println("传自己的实现作为FunctionalInterface的内容");};
        p.print("s");
    }
}
