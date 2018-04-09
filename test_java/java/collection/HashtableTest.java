package collection;

import java.util.Hashtable;

/**
 * Hashtable的key和value都不允许为空
 */
public class HashtableTest {
    public static void main(String[] args) {
        Hashtable<Object, Object> table = new Hashtable<Object, Object>();

        table.put(null, "1");
        table.put("2", null);
    }
}
