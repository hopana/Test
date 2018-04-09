package collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapMergeTest {
    public static void main(String[] args) {
        Map map1 = new HashMap();
        for (int i = 0; i < 5; i++) {
            map1.put(i, i);
        }

        Map map2 = new HashMap();
        for (int i = 0; i < 10; i++) {
            map2.put(i, i);
        }

        map1.putAll(map2);

        System.out.println(map1);

    }
}
