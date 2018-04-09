package syntax.abstract_interface;

public interface InterfaceTest {

    /* ---------------------------- 变量的定义 ---------------------------- */
    // 接口中的成员变量类型默认为public static final且只能为public static final，
    // 既然是final的，就必须显式的初始化
    //public String a; 错误
    public String a = "必须初始化";
    public static final String b = "默认且必须为此类型";
    //private String b ="不能用private修饰";
    //protected String c ="不能用protected修饰";

    // 不能被private、protected修饰
    //protected String b;
    //private String c;

    /* ---------------------------- 方法的定义 ---------------------------- */
    // 接口中的抽象方法只能是public类型的，并且默认即为public abstract类型
    public abstract void sayGoodbye();

    public void sayHello();

    void sayGoodmorrning();
    // 接口中不能有普通方法
    //public void sayGoodnight(){
    //
    //}

}

// 接口只能继承接口，不能实现接口，所以是extends，不能用implements
interface Test extends InterfaceTest {

}