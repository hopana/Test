package newinterface;

import java.util.function.Supplier;

/**
 * java8接口允许有默认方法、静态方法
 *
 * @author hupan
 * @date 2017-05-14 11:10:20
 */
public class DefaultInterfaceDemo {

    interface Defaulable {
        // java8的接口允许有默认方法，实现类可以重写也可以不重写这些默认方法
        default String notRequired() {
            return "Default implementation";
        }
    }

    private interface DefaulableFactory {
        // java8的接口允许有静态方法
        static Defaulable create( Supplier< Defaulable > supplier ) {
            return supplier.get();
        }
    }

    private static class DefaultableImpl implements Defaulable {
        // 没有重写默认方法
    }

    private static class OverridableImpl implements Defaulable {
        // 重写了默认方法
        @Override
        public String notRequired() {
            return "Overridden implementation";
        }
    }

    public static void main( String[] args ) {
        Defaulable defaulable = DefaulableFactory.create( DefaultableImpl::new );
        System.out.println( defaulable.notRequired() );

        defaulable = DefaulableFactory.create( OverridableImpl::new );
        System.out.println( defaulable.notRequired() );
    }

}