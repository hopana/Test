package override.pkg1;

/**
 * 波音747（子类）
 *
 * @author hupan
 * @date 2018/09/06
 */
public class Boeing747 extends Plane {

    @Override
    public void refuel() {
        System.out.println(">>>>>>>>加油之前先进行例行检查");
        super.refuel();
    }

    @Override
    public void flyToTransferStation() {
        System.out.println(">>>>>>>>本次飞直达，不经过中转站");
    }

}
