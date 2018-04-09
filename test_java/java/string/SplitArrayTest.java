package string;

public class SplitArrayTest {
    public static void main(String[] args) {

        String str = "0#123#098";
        String str2 = "#";

        String[] temp = str.split("#");
        String[] temp2 = str2.split("#");

        System.out.println(temp2.length);

        if (temp[3] != null && !"".equals(temp[3])) {
            System.out.println("yeah!");
        }
    }
}
