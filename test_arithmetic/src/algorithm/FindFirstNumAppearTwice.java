package algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 找出数组里第一次出现两次的数字
 *
 * @author hupan
 * @date 2017-08-25 10:05:28
 */
public class FindFirstNumAppearTwice {
    public static void main(String[] args) {
        int[] arr = {6, 2, 3, 8, 3, 5, 1, 8, 9, 5, 4};

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        for (int a : arr) {
            Integer value = map.get(a);
            if (value == null || value == 0) {
                map.put(a, 1);
            } else {
                map.put(a, value + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 2) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
                break;
            }
        }
    }
}
