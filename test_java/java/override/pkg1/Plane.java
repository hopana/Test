package override.pkg1;

/**
 * 飞机（父类）
 *
 * @author hupan
 * @date 2018/09/06
 */
public class Plane {
    public void flyToUSA() {
        System.out.println("飞往美国。。。。。。。。。");
        refuel();
        flyToHK();
        flyToTransferStation();
        flyToNewYork();
    }

    public void refuel() {
        System.out.println("先加油。。。。。。。。。。。");
    }

    public void flyToHK() {
        System.out.println("飞往香港。。。。。。。。。。。");
    }

    public void flyToTransferStation() {
        System.out.println("飞往中转站。。。。。。。。。。。");
    }

    public void flyToNewYork() {
        System.out.println("飞往纽约。。。。。。。。。。。");
    }

}