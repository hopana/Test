package string;

public class SplitTest7 {
    public static void main(String[] args) {
        String s = "M0:33010301130806000312";
        String flag = s.split(":")[0];
        System.out.println(flag);
        String s2 = "18823752004";
        String[] temp = s2.split("#");
        System.out.println(temp.length);

    }
}
