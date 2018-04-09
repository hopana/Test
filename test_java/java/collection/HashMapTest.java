package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * HashMap的key运行一个为空（key本来也不允许重复），如果多个key为空，后面的key会覆盖前面的key
 * HashMap的value允许多个为空
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Object, String> map = new HashMap<Object, String>();

        map.put(null, "1");
        map.put(null, "2");
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", null);
        map.put("d", null);
        map.put("e", null);

        Iterator<Map.Entry<Object, String>> itr = map.entrySet().iterator();

        while (itr.hasNext()) {
            Map.Entry<Object, String> entry = itr.next();

            Object key = entry.getKey();
            String value = entry.getValue();

            System.out.println("key:" + key + " value:" + value);
        }

    }
}
