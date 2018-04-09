package _abstract;

// 接口不能用private，protected,static，final等修饰
public interface InterfaceDemo {

    /*
     * 接口中的成员变量，不管定义的时候是否用public static final修饰
     * 默认总是public static final修饰，而且必须给变量赋初值
     * 最后，其实就变成了不可改变的常量
     */
    int a = 0;

    public static final int b = 0;

    public abstract void fun();

    /**
     * @return
     */
    int fun1();

    public void fun2();
}


class Demo implements InterfaceDemo {
    @Override
    public void fun() {

        //InterfaceDemo.a = 10; 此处报错，不可改变a的值，a默认为static final的
        System.out.println("overrided interface function......");
    }

    @Override
    public int fun1() {
        return 0;
    }

    @Override
    public void fun2() {

    }
}