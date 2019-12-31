package functional.functional_interface_asyncall;

/**
 * 定义一个@FunctionalInterface接口
 *
 * @author hupan
 * @date 2018/12/29
 */
public interface GofFunction<T1, T2> {
    void execute(T1 t1, T2 t2);
}
