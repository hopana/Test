package syntax;

public class NullTest {
    public static void main(String[] args) {
        String s = null;

        //不写s!=null会抛异常
        if (s != null && s.endsWith("World")) {
            System.out.println("Bingo!");
        }
    }
}
