package string;

public class SplitToStringArray {
    public static void main(String[] args) {
        String s1 = "aaa,bb,";
        String s2 = "aaa|bb|";

        String[] arr1 = s1.split(",");
        String[] arr2 = s2.split("\\|"); // |要转义为\\|

        // System.out.println(arr1[2]);

        for (String s : arr2) {
            System.out.println(s);
        }
    }
}
