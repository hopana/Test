package syntax;

import java.util.Arrays;

/**
 * 特殊重载方法测试
 *
 * @author hupan
 * @date 2019/06/04
 */
public class OverLoadTest {

    public void test(int i, String s1, String...strs) {

    }

    public void test(int j, String...strs) {

    }

    public static void main(String[] args) {
        OverLoadTest ot = new OverLoadTest();
        // ot.test(1, "hello", "world"); 报错

        System.out.println(Arrays.toString(",1,2,".split(",")));
    }

}
