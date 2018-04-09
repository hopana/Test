package string;

public class ReplaceTest {

    public static String replace(String s) {
        return s.replaceAll("0.00", "");

    }

    public static void main(String[] args) {
        String s = "0.0000002344";
        System.out.println(replace(s));
    }
}
