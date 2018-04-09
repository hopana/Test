package string;

public class StartWithTest {
    public static void main(String[] args) {
        String month = "02";
        if (month.startsWith("0")) {
            month = month.substring(1, 2);
        }
        System.out.println(month);
    }
}
