package string;

public class HashCodeTest {
    public static void main(String[] args) {
        String s1 = "String1";
        String s2 = "String1";
        String s3 = s1;
        String s4 = new String(s1);

        System.out.println(s1.hashCode() == s2.hashCode());
        System.out.println(s1.hashCode() == s3.hashCode());
        System.out.println(s1.hashCode() == s4.hashCode());
        System.out.println("---------------------");
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s1.equals(s4));
        System.out.println("---------------------");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);
    }
}
