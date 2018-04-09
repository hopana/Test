package _abstract;

public class AbstractClassDemo {
    public static void main(String[] args) {
        new SonOfAbstractClass().fun1();
    }

}

abstract class AbstractClass {
    int a = 0;
    public static final int b = 100;

    public AbstractClass() {

    }

    public abstract void fun1();

    protected abstract void fun2();

    public void foo() {
        System.out.println("non abstract function");
    }
}

class SonOfAbstractClass extends AbstractClass {

    @Override
    public void fun1() {
        System.out.println(a);
    }

    @Override
    protected void fun2() {

    }

}