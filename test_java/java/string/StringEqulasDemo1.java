package string;

public class StringEqulasDemo1 {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "a";
        String s3 = s1;
        String s4 = new String("a");
        String s5 = s4;
        String s6 = new String("a");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);

        System.out.println(s1 == s4);

        System.out.println(s4 == s5);
        System.out.println(s4 == s6);
    }
}
