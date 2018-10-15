package oop;

import java.util.concurrent.ExecutionException;

/**
 * 抽象控制器
 *
 * @author hupan
 * @date 2018/09/27
 */
public abstract class AbstractParkController<T> {
    protected static final long DEFAULT_WAIT_TIME = 10 * 1000;

    /**
     * 停车逻辑
     *
     * @param t 停车对象
     * @return 否操作成功
     * @throws ExecutionException
     * @throws InterruptedException
     */
    boolean park(T t) throws ExecutionException, InterruptedException {
        if (!canPark(t)) {
            return false;
        }

        if (isVip(t)) {
            return doVipPark(t);
        }

        return doPark(t);
    }

    /**
     * 车辆驶离逻辑
     *
     * @param t 停车对象
     * @return 是否操作成功
     * @throws ExecutionException
     * @throws InterruptedException
     */
    boolean unpark(T t) throws ExecutionException, InterruptedException {
        if (isVip(t)) {
            return doVipUnPark(t);
        }

        return doUnPark(t);
    }

    /**
     * 是否可以停车
     *
     * @param t 停车对象
     * @return 否操作成功
     */
    abstract boolean canPark(T t);

    /**
     * 是否是vip
     *
     * @param t 停车对象
     * @return 否操作成功
     */
    abstract boolean isVip(T t);

    /**
     * 普通停车逻辑
     *
     * @param t 停车对象
     * @return 否操作成功
     * @throws ExecutionException
     * @throws InterruptedException
     */
    abstract boolean doPark(T t) throws ExecutionException, InterruptedException;

    /**
     * 会员停车逻辑
     *
     * @param t 停车对象
     * @return 否操作成功
     * @throws ExecutionException
     * @throws InterruptedException
     */
    abstract boolean doVipPark(T t) throws ExecutionException, InterruptedException;

    /**
     * 普通驶离逻辑
     *
     * @param t 停车对象
     * @return 否操作成功
     * @throws ExecutionException
     * @throws InterruptedException
     */
    abstract boolean doUnPark(T t) throws ExecutionException, InterruptedException;

    /**
     * 会员驶离逻辑
     *
     * @param t 停车对象
     * @return 否操作成功
     * @throws ExecutionException
     * @throws InterruptedException
     */
    abstract boolean doVipUnPark(T t) throws ExecutionException, InterruptedException;

}
