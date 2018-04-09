package singleton;

/**
 * 静态内部类实现单例
 *
 * @author hupan
 * @date 2017-08-22 23:38:44
 */
public class StaticInnerClassSingleton {
    public static void main(String[] args) {
        //StaticSingleton singletonClass1 = StaticSingleton.getInstance();

        StaticSingleton s = new StaticSingleton();
    }
}


class StaticSingleton {
    public StaticSingleton() {
        System.out.println("构造方法被执行");
    }

    private static class SingletonHolder {
        private SingletonHolder() {
            System.out.println("静态内部类构造方法被执行");
        }

        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return SingletonHolder.instance;
    }
}