package optional;

import org.junit.Test;

import java.util.Optional;

/**
 * comment
 *
 * @author hupan
 * @since 2018-02-09 11:48
 */
public class OptionalTest1 {
    /**
     * Optional.of()或者Optional.ofNullable()：创建Optional对象，差别在于of不允许参数是null，而ofNullable则无限制。
     */
    @Test
    public void test1() {
        // 参数不能是null
        Optional<Integer> optional1 = Optional.of(1);
        // 参数可以是null
        Optional<Integer> optional2 = Optional.ofNullable(null);
        // 参数可以是非null
        Optional<Integer> optional3 = Optional.ofNullable(2);
    }

    /**
     * Optional.empty()：所有null包装成的Optional对象。
     */
    @Test
    public void test2() {

        Optional<Integer> optional1 = Optional.ofNullable(null);
        Optional<Integer> optional2 = Optional.ofNullable(null);
        // true
        System.out.println(optional1 == optional2);
        // true
        System.out.println(optional1 == Optional.<Integer>empty());

        Object o1 = Optional.<Integer>empty();
        Object o2 = Optional.<String>empty();
        // true
        System.out.println(o1 == o2);
    }

    /**
     * isPresent()：判断值是否存在
     */
    @Test
    public void test3() {
        Optional<Integer> optional1 = Optional.ofNullable(1);
        Optional<Integer> optional2 = Optional.ofNullable(null);

        // isPresent判断值是否存在
        System.out.println(optional1.isPresent());
        System.out.println(optional2.isPresent());
    }

    /**
     * ifPresent(Consumer consumer)：如果option对象保存的值不是null，则调用consumer对象，否则不调用
     */
    @Test
    public void test4() {
        Optional<Integer> optional1 = Optional.ofNullable(1);
        Optional<Integer> optional2 = Optional.ofNullable(null);

        // 如果不是null,调用Consumer
        optional1.ifPresent(t -> System.out.println("value is " + t));

        // null,不调用Consumer
        optional2.ifPresent(t -> System.out.println("value is " + t));
    }

    /**
     * orElse(value)：如果optional对象保存的值不是null，则返回原来的值，否则返回value
     */
    @Test
    public void test5() {
        Optional<Integer> optional1 = Optional.ofNullable(1);
        Optional<Integer> optional2 = Optional.ofNullable(null);

        // orElse:true
        System.out.println(optional1.orElse(1000) == 1);
        // orElse:true
        System.out.println(optional2.orElse(1000) == 1000);
    }

    /**
     * orElseGet(Supplier supplier)：功能与orElse一样，只不过orElseGet参数是一个对象
     */
    @Test
    public void test6() {
        Optional<Integer> optional1 = Optional.ofNullable(1);
        Optional<Integer> optional2 = Optional.ofNullable(null);

        //true
        System.out.println(optional1.orElseGet(() -> 1000) == 1);

        //true
        System.out.println(optional2.orElseGet(() -> 1000) == 1000);
    }

    /**
     * orElseThrow()：值不存在则抛出异常，存在则什么不做，有点类似Guava的Precoditions
     */
    @Test
    public void test7() throws RuntimeException {
        Optional<Integer> optional1 = Optional.ofNullable(1);
        Optional<Integer> optional2 = Optional.ofNullable(null);

        Integer i1 = optional1.orElseThrow(IllegalStateException::new);
        System.out.println(i1);

        // 抛出异常
        Integer i2 = optional2.orElseThrow(IllegalStateException::new);
        System.out.println(i2);
    }

    /**
     * filter(Predicate)：判断Optional对象中保存的值是否满足Predicate，并返回新的Optional。
     */
    @Test
    public void test8() {
        Optional<Integer> optional1 = Optional.ofNullable(1);
        Optional<Integer> optional2 = Optional.ofNullable(null);

        Optional<Integer> filter1 = optional1.filter((a) -> a == null);
        Optional<Integer> filter2 = optional1.filter((a) -> a == 1);
        Optional<Integer> filter3 = optional2.filter((a) -> a == null);
        // false
        System.out.println(filter1.isPresent());
        // true
        System.out.println(filter2.isPresent());
        // true
        System.out.println(filter2.get().intValue() == 1);
        // false
        System.out.println(filter3.isPresent());
    }

    /**
     * map(Function)：对Optional中保存的值进行函数运算，并返回新的Optional(可以是任何类型)
     */
    @Test
    public void test9() {
        Optional<Integer> optional1 = Optional.ofNullable(1);
        Optional<Integer> optional2 = Optional.ofNullable(null);

        Optional<String> str1Optional = optional1.map((a) -> "key" + a);
        Optional<String> str2Optional = optional2.map((a) -> "key" + a);

        // key1
        System.out.println(str1Optional.get());
        // false
        System.out.println(str2Optional.isPresent());
    }

    /**
     * flatMap()：功能与map()相似，差别请看如下代码。
     * flatMap方法与map方法类似，区别在于mapping函数的返回值不同。
     * map方法的mapping函数返回值可以是任何类型T，而flatMap方法的mapping函数必须是Optional。
     */
    @Test
    public void test10() {
        Optional<Integer> optional1 = Optional.ofNullable(1);

        Optional<Optional<String>> str1Optional = optional1.map((a) -> Optional.of("key" + a));

        Optional<String> str2Optional = optional1.flatMap((a) -> Optional.of("key" + a));

        // key1
        System.out.println(str1Optional.get().get());
        // key1
        System.out.println(str2Optional.get());
    }

}
