package string;

public class SplitTest6 {
    public static void main(String[] args) {
        //String s = ",王二小,小刘,张元庆,马化腾,阿里巴巴,";
        String s = "王二小,小刘,张元庆,马化腾,阿里巴巴,";
        String[] arr = s.split(",");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
            System.out.println("---");
        }
    }
}
