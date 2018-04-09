package collection;

import java.util.HashSet;
import java.util.Set;

/**
 * HashSet运行为空，元素不可重复，不保证元素顺序
 */
public class TestHashSet {
    public static void main(String[] args) {
        Set<Object> set = new HashSet<Object>();
        set.add("A");
        set.add("B");
        set.add("a");
        set.add(null);
        set.add("D");
        set.add("F");
        set.add("A");
        set.add(null);

        for (Object s : set) {
            System.out.println(s);
        }

    }
}
