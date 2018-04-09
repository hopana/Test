package syntax;

public class JumpLoop {
    public static void main(String[] args) {
        // 第一种方式:采用标识
        ok:
        for (int j = 0; j < 2; j++)
            for (int i = 0; i < 100; i++) {
                if (i == 10)
                    break ok;// 当然continue也可以使用,但return则无法使用
                else
                    System.out.print(i + " ");
            }
        System.out.println();
        // 第二种方式采用自定义的变量(Boolean值),并配合break使用
        boolean flag = false;
        for (int j = 0; j < 2 && !flag; j++)
            for (int i = 0; i < 100; i++) {
                if (i == 10) {
                    flag = true;
                    break;
                } else
                    System.out.print(i + " ");
            }
    }
}
