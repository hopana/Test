package asyn;

/**
 *
 * @author zw_com
 *  测试类
 *  用于测试接口回掉的过程
 */
public class Test {
    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        MainFunction mf = new MainFunction(calculate);
        mf.operational();

        for (int i = 0; i<100; i++) {
            System.out.println("aaaaaaaaaaa" + i);
        }
    }
}