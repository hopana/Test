package string;

public class SplitTest5 {
    public static void main(String[] args) {
        String[] s = {"1(3)", "443(2)", "530(4)", "432(5)", "3(4)"};
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i].trim().substring(0, s[i].length() - 3));
        }
    }
}
