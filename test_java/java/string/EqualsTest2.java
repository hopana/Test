package string;

public class EqualsTest2 {

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "he" + new String("llo");
        String s3 = "hello";

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
    }
}
