package string;

public class EqualsTest {

    public static void main(String[] args) {
        String value = "0.00";
        if (value.equals("0.0") || value.equals("0.00")) {
            value = "";
        }
        System.out.println(value);
    }
}
