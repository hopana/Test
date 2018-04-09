package api;

/**
 * @author Administrator
 * @version 1.0
 * @comment：Math.floor()方法测试
 * @created 2016-03-07 22:05:05
 */
public class MathFloorTest {
    public static void main(String[] args) {
        double value = Math.random();
        double money = Math.floor(value * 100) / 100;

        System.out.println(value);
        System.out.println(money);
    }
}
