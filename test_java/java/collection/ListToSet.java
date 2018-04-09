package collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * List转换成Set
 *
 * @author hupan
 * @version 2.0
 * @created 2015-8-12 上午10:52:02
 */
public class ListToSet {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        list.add("hupan");
        list.add("hupan");
        list.add("hupan");
        list.add("pan");
        list.add("pan");

        Set<String> set = new HashSet<String>(list);

        for (String s : set) {
            System.out.println(s);
        }
    }
}
