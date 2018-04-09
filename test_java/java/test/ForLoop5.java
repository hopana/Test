package test;

public class ForLoop5 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2 * i + 1; k++) {
                System.out.print("*");
            }

            for (int a = 0; a < 4 - i; a++) {
                System.out.print(" ");
            }

            for (int b = i; b < 5; b++) {
                System.out.print(" ");
            }
            for (int c = 2 * i + 1; c > 0; c--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
