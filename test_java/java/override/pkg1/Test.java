package override.pkg1;

/**
 * 主测试类
 *
 * @author hupan
 * @date 2018/09/06
 */
public class Test {

    public static void main(String[] args) {
        Plane plane = new Boeing747();
        plane.flyToUSA();
    }
}
