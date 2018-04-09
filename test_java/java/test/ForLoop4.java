package test;

public class ForLoop4 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }
            for (int k = i + 1; k < 5; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
