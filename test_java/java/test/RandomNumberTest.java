package test;

import java.util.Random;

public class RandomNumberTest {
    public static void main(String[] args) {
        Random r = new Random();
        int n = r.nextInt(10000);

        int m = (int) (Math.random() * 10000);

        System.out.println(n);
        System.out.println(m);
    }
}
