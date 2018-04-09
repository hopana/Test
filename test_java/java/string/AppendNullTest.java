package string;

public class AppendNullTest {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        String s = null;
        sb.append(s);
        System.out.println(String.valueOf(s));
        //System.out.println(String.valueOf(null));
        System.out.println(sb == null);
        System.out.println(sb);
        System.out.println(sb.append(s));
    }
}
