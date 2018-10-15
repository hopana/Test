package oop;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.*;

/**
 * 停车场控制类
 *
 * @author hupan
 * @date 2018/09/27
 */
public class ParkController extends AbstractParkController<Parker> {
    /**
     * 普遍区位置大小
     */
    private static final int NORMAL_SIZE = 1000;
    /**
     * 会员区位置大小
     */
    private static final int VIP_SIZE = 50;

    /**
     * 初始化
     */
    private static Park park = Park.init(NORMAL_SIZE, VIP_SIZE);
    /**
     * 执行线程
     */
    private ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(10, new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());

    /**
     * 停车
     * @param parker 客户
     * @return 是否操作成功
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Override
    public boolean doPark(Parker parker) throws ExecutionException, InterruptedException {
        Future<Boolean> future = executorService.submit(() -> {
            boolean isSucc = true;
            try {
                park.normalQueue.put(parker);
            } catch (InterruptedException e) {
                isSucc = false;
                e.printStackTrace();
            }

            return isSucc;
        });

        return future.get();
    }

    /**
     * vip停车
     * @param parker 客户
     * @return 是否操作成功
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Override
    boolean doVipPark(Parker parker) throws ExecutionException, InterruptedException {
        Future<Boolean> future = executorService.submit(() -> {
            boolean isSucc = true;
            try {
                park.vipQueue.put(parker);
            } catch (InterruptedException e) {
                isSucc = false;
                e.printStackTrace();
            }

            return isSucc;
        });

        return future.get();
    }

    /**
     * 驶离
     * @param parker 客户
     * @return 是否操作成功
     */
    @Override
    boolean doUnPark(Parker parker) throws ExecutionException, InterruptedException {
        Future<Boolean> future = executorService.submit(() -> {
            park.normalQueue.remove();
            return true;
        });

        return future.get();
    }

    /**
     * 驶离
     * @param parker 客户
     * @return 是否操作成功
     */
    @Override
    boolean doVipUnPark(Parker parker) throws ExecutionException, InterruptedException {
        Future<Boolean> future = executorService.submit(() -> {
            park.vipQueue.remove(parker);
            return true;
        });

        return future.get();
    }

    /**
     * 是否可以停车 TODO 待完善
     *
     * @param parker 客户
     * @return 是否操作成功
     */
    @Override
    boolean canPark(Parker parker) {
        return true;
    }

    /**
     * 判断是否是vip
     *
     * @param parker 客户
     * @return 是否操作成功
     */
    @Override
    boolean isVip(Parker parker) {
        return parker.isVip();
    }

}



