package generic;

/**
 * 泛型演示类
 *
 * @author 杨元
 */
public class Generic {

    /**
     *
     * @param c 用来创建泛型对象
     * @param <T> 声明一个泛型T
     * @return 返回T
     * @throws InstantiationException 抛出InstantiationException异常
     * @throws IllegalAccessException 抛出IllegalAccessException异常
     */
    public <T> T getObject(Class<T> c) throws InstantiationException, IllegalAccessException {
        //创建泛型对象
        T t = c.newInstance();
        return t;
    }
}
