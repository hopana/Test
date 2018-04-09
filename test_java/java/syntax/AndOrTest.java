package syntax;

public class AndOrTest {
    public static void main(String[] args) {
        String s1 = "hupan";
        int a = 100;
        int b = 60;
        if ("hupan1".equals(s1) || a == 100 && b == 60) {
            System.out.println("OK");
        }

        System.out.println(false && true || true);
        System.out.println(true || true && false);
        System.out.println(false || true && false);
        System.out.println(false || true && true);
    }
}
