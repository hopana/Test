package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author HP
 * @version 1.0
 * @comment： 对HashMap按key排序
 * @created 2016-02-28 10:00:59
 */
public class HashMapSortByKey {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();

        map.put("1", "e");
        map.put("3", "c");
        map.put("2", "a");
        map.put("4", "d");
        map.put("5", "b");

        // 将map.entrySet()转换成list
        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());

        // 通过比较器来实现排序
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            // 升序排序
            public int compare(Entry<String, String> o1, Entry<String, String> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        for (Map.Entry<String, String> mapping : list) {
            System.out.println(mapping.getKey() + ":" + mapping.getValue());
        }
    }
}
