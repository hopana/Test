package algorithm;

/**
 * 斐波那契数列算法实现
 * 1、1、2、3、5、8、13、21、34、……
 *
 * @author hupan
 * @date 2017-08-28 15:49
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(getFibonacci1(9));
    }

    public static int getFibonacci1(int n) {
        if (n <= 2) {
            return 1;
        } else {
            return getFibonacci1(n - 1) + getFibonacci1(n - 2);
        }
    }

    public static int getFibonacci2(int n) {
        if (n <= 2) {
            return 1;
        }

        int n1 = 1, n2 = 1, sn = 0;
        for (int i = 0; i < n - 2; i++) {
            sn = n1 + n2;
            n1 = n2;
            n2 = sn;
        }

        return sn;
    }
}
