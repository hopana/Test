package syntax;

public class ParamModifyTest {
    public static void main(String[] args) {
        ParamModifyTest p = new ParamModifyTest();
        for (int i = 0; i < 10; i++) {
            fun(i + "x");
        }
    }

    public static void fun(String s) {
        s = s + "1";
        System.out.println(s);
    }
}
