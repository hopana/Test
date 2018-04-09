package number;

/**
 * 表示范围小的变量会自动向表示范围大的变量的类型转换: byte-->short-->int-->long-->float-->double
 */
public class NumberCastTest {
    public static void main(String[] args) {

        byte a = 15;
        double b = 2.5;
        int c = 5;

        // byte d = a/c;
        int d = a / c; // a是byte类型，c是int类型，a/c的结果或自动转换成范围大的精度高的int型

        System.out.println(a / b * 10);

    }
}
