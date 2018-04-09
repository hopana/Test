package mathlogic;

public class ChangeTwoNumbers {
    public static void main(String[] args) {
        int a = 5, b = 9;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        double c = 5.4, d = 9.6;
        c = c + d;
        d = c - d;
        c = c - d;

        System.out.println("a=" + a + ",b=" + b);
        System.out.println("c=" + c + ",d=" + d);

    }
}
