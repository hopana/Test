package syntax;

/**
 * 数字的移位运算
 *
 * @author hupan
 * @date 2017-08-11 11:20:26
 */
public class NumberShiftOperation {
    public static void main(String[] args) {
        System.out.println(20 >> 2);// 20二进制：10100 原码：00010100 右移2位：00000101
        System.out.println(20 >>> 2);
        System.out.println(-20 >> 2);
        System.out.println(-20 >>> 2);
    }
}
