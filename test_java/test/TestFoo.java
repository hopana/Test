/**
 * TODO 注释
 *
 * @author hupan
 * @date 2019/05/31
 */
public class TestFoo {

    public static void main(String[] args) {
            String param1 = "1,2";
            String param2 = "1,2,";
            String param3 = ",1,2,";

            System.out.println(param1.split(",").length);
            System.out.print(param2.split(",").length);
            System.out.println(" " + param2.split(",", -1).length);
            System.out.print(param3.split(",").length);
            System.out.println(" " + param3.split(",", -1).length);
    }
}
