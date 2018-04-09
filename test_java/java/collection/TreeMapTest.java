package collection;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        Map<Object, Object> map = new TreeMap<Object, Object>(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return -1;
            }
        });

        // map.put(null, 1);
        map.put(2, null);
        map.put(3, null);
        map.put(4, null);

        for (Entry<Object, Object> entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();

            System.out.println("key=" + key + " value=" + value);
        }

    }
}
