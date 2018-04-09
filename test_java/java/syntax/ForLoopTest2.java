package syntax;

public class ForLoopTest2 {
    public static void main(String[] args) {
        // i减到最后溢出了，负最小后变成正数了
        for (int i = 10; ; i--) {
            if (i > 0) {
                System.out.println("i=" + i);
            }
        }
    }
}
