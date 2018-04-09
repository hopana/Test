package reflection;

public class GetClassTest {
    public static void main(String[] args) {
        System.out.println(new GetClassTest().getClass().getName());
        System.out.println(new GetClassTest().getClass().getResource("reflection.GetClassTest"));
    }
}
