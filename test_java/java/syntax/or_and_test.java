package syntax;

public class or_and_test {
    public static void main(String[] args) {
        if (10 == 10 || 10 / 0 == 0) {
            System.out.println("发生短路，后面的表达式没有判断");
        }
        if (10 == 10 | 10 / 0 == 0) {
            System.out.println("没有短路，后面的表达抛出异常");
        }
    }
}
