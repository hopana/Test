package method;

public class GetSimpleNameTest {
    public static void main(String[] args) {
        //打印带包名的类名称
        System.out.println(new GetSimpleNameTest().getClass().getName());
        //打印不带包名的类名称
        System.out.println(new GetSimpleNameTest().getClass().getSimpleName());
    }
}
