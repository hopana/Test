package syntax._static;

/**
 * 静态方法不可被重写
 *
 * @author hupan
 * @date 2018/10/10
 */
public class StaticOverrideTest {
    public static void main(String[] args) {
        A a = new B();
        a.test();
    }
}

class A {
    public static void test() {
        System.out.println("test A");
    }
}

class B extends A {
    public static void test() {
        System.out.println("test B");
    }
}
