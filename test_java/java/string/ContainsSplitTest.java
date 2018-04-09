package string;

public class ContainsSplitTest {
    public static void main(String[] args) {
        String s = "41#12345123451234512#123451234512345123#100";
        System.out.println(s.contains("#"));
        String[] temp = s.split("#");
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }
    }
}
