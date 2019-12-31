package syntax;

public class WhileTest {

    public static void main(String[] args) {
        int i = 1;
        while(i < 100) {
            System.out.println("i小于100：" + i);
            i = i * 2;
        }
    }

}
