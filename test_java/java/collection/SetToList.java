package collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Set转换成List
 *
 * @author hupan
 * @version 2.0
 * @created 2015-8-12 上午10:44:11
 */
public class SetToList {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();

        set.add("hupan");
        set.add("hupan");
        set.add("hupan");
        set.add("pan");
        set.add("pan");
        set.add("hu");

        List<String> list = new ArrayList<String>(set);

        for (String s : list) {
            System.out.println(s);
        }
    }
}
