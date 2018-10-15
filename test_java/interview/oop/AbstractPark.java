package oop;

import java.util.concurrent.BlockingQueue;

/**
 * 停车场抽象类
 *
 * @author hupan
 * @date 2018/09/27
 */
public abstract class AbstractPark<T> {
    /** 默认普通区停车位大小 */
    protected static final int DEFAULT_NORMAL_SIZE = 1000;
    /** 默认vip去停车位大小 */
    protected static final int DEFAULT_VIP_SIZE = 50;
    /** 普通区停车队列 */
    protected BlockingQueue<T> normalQueue;
    /** vip区停车队列 */
    protected BlockingQueue<T> vipQueue;

}
