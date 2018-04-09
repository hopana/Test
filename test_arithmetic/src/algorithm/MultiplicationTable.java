package algorithm;

public class MultiplicationTable {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf(j + "*" + i + "=");
                System.out.printf("%-4d", i * j);
            }
            System.out.println();
        }
    }
}
