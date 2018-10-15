package exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO 注释
 *
 * @author hupan
 * @date 2018/10/10
 */
public class ConcurrentException {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>(16);
        map.put("a", 100);
        map.put("b", 200);
        map.put("c", 300);
        map.put("d", 400);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        for (Integer a : list) {
            list.remove(a);
        }
    }
}
