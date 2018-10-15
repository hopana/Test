package oop;

import java.util.Comparator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * 停车场
 *
 * @author hupan
 * @date 2018/09/27
 */
public class Park extends AbstractPark<Parker> {
    /**
     * 默认普通区队列大小
     */
    private static int normalQueueSize;
    /**
     * 默认vip区队列大小
     */
    private static int vipQueueSize;

    /**
     * 初始化停车场
     * @param normalSize 普通区队列大小
     * @param vipSize vip区队列大小
     * @return
     */
    public static Park init(int normalSize, int vipSize) {
        normalQueueSize = normalSize;
        vipQueueSize = vipSize;
        return parkHolder.park;
    }

    /**
     * 单例停车场实现
     */
    private static class parkHolder {
        private static Park park = new Park(normalQueueSize, vipQueueSize);
    }

    /**
     * 默认无参构造函数
     */
    private Park() {
        this.normalQueue = new LinkedBlockingQueue<>(DEFAULT_NORMAL_SIZE);
        this.vipQueue = new PriorityBlockingQueue<>(DEFAULT_VIP_SIZE, Comparator.comparingInt(Parker::getVipLevel));
    }

    /**
     * 标准构造函数
     *
     * @param normalQueueSize 普通区队列大小
     * @param vipQueueSize    vip区队列大小
     */
    private Park(int normalQueueSize, int vipQueueSize) {
        this.normalQueue = new LinkedBlockingQueue<>(normalQueueSize);
        this.vipQueue = new PriorityBlockingQueue<>(vipQueueSize);
    }

}
