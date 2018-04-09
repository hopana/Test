package collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 利用Set给List去重
 *
 * @author hupan
 * @version 1.0
 * @created 2015-8-12 上午10:28:42
 */
public class SetTest {
    public static void main(String[] args) {

        List list = new ArrayList();

        list.add("zhaopeng");
        list.add("zhaopeng");
        list.add("zhaopeng");
        list.add("momo");
        list.add("momo");
        list.add("momo");

        for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
            String object = (String) iterator.next();
            System.err.println(object);
        }

        System.err.println("----------------------");

        List newList = SetTest.removeList(list);

        for (Iterator iterator = newList.iterator(); iterator.hasNext(); ) {
            String object = (String) iterator.next();
            System.err.println(object);
        }
    }

    // 去重
    public static List removeList(List list) {
        Set set = new HashSet(list);

        return new ArrayList(set);
    }
}