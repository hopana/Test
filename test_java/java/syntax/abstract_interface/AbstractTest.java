package syntax.abstract_interface;

public abstract class AbstractTest {

    /* ---------------------------- 变量的定义 ---------------------------- */
    public String name;
    // 可以用private、protected修饰
    private String a;
    protected String b;
    // 可以有静态变量
    static String c;

    /* ---------------------------- 方法的定义 ---------------------------- */
    // 普通方法
    public void sayHello() {
        System.out.println("hello...");
    }

    // 抽象方法
    public abstract void sayGoodbye();

    // 抽象方法错误的写法:不要大括号，无方法体
    //public abstract void sayHello(){};

    // 构造方法
    public AbstractTest() {
        System.out.println("constructor...");
    }

    /* ------------------------------ 测试 ------------------------------*/
    public static void main(String[] args) {
        // 抽象类可以有构造方法，但是不能被实例化
        //AbstractTest a = new AbstractTest();
    }

}

// 抽象类可以继承抽象类
abstract class Son extends AbstractTest {

}