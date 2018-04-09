package _abstract;

public class AbstractFunctionTest {

}

abstract class C {

    // 抽象方法不能被static修饰
    // abstract static void test1();

    // 抽象方法不能被native修饰
    // abstract native void test2();

    // 抽象方法不能被synchronized修饰
    // abstract synchronized void test2();

    abstract void test();
}