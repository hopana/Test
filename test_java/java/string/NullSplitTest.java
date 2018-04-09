package string;

public class NullSplitTest {

    public static void main(String[] args) {
        String s = "";
        String[] temp = s.split("#");
        System.out.println(temp.length);
        for (String str : temp) {
            System.out.println(str);
        }

    }

}
