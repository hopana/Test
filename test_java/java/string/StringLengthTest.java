package string;

public class StringLengthTest {
    public static void main(String[] args) {
        String s = "测试一下带中文的字符串的长度怎么算";
        System.out.println(s.length());
        System.out.println(s.getBytes().length);
    }
}
