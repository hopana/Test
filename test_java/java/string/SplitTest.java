package string;

public class SplitTest {

    public static void main(String[] args) {
        //String str = "共3人(周一波,周一波,赵云)";
        String str = "周一波,周一波,赵云";
        //String str = "boo:and:foo";
        String[] arr = str.split(",");
        System.out.println(arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        int n = str.indexOf("(");
        System.out.println(n);
        String s = str.substring(n + 1, str.length());
        System.out.println(s);
    }
}
