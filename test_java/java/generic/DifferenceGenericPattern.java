package generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * TODO 注释
 *
 * @author hupan
 * @date 2018/10/10
 */
public class DifferenceGenericPattern {
    public static void set1(List<?> list) {

    }

    public static void set2(List<Object> list) {

    }

    public static void set3(List<? extends Object> list) {

    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        set1(list1);

        List<Object> list2 = new ArrayList<>();
        list2.add(1);
        list2.add("2");
        list2.add(new HashMap<>());

        set2(list2);

        List<String> list3 = new ArrayList<>();
        list3.add("1");
        list3.add("3");
        list3.add("4");
        set3(list3);
    }
}