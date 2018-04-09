package string;

public class IndexOfTest {
    public static void main(String[] args) {
        String name = "CardDetail_20101215_0 (2).txt";
        // 没有指定的字符串返回-1，而不是返回0
        System.out.println(name.indexOf("CardDetail"));
    }
}
