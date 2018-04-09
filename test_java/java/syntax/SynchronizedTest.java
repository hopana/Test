package syntax;

public class SynchronizedTest {

    public synchronized void test() {
        System.out.println("普遍方法可以用synchronized关键字修饰");
    }

    public synchronized static void testStatic() {
        System.out.println("静态方法可以用synchronized关键字修饰");
    }

    public void testBlock() {
        Object obj = new Object();

        synchronized (obj) {
            System.out.println("一般对象可以被synchronized关键字修饰");
        }

        synchronized (Object.class) {
            System.out.println("类对象可以被synchronized关键字修饰");
        }
    }

    public static void main(String[] args) {

    }

}
