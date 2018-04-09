package string;

import java.util.ArrayList;
import java.util.List;

public class SplitTest3 {

    public static void main(String[] args) {
        List<String> users = new ArrayList<String>();
        users.add("刘备");
        users.add("曹操");
        users.add("吕布");
        users.add("赵云");
        users.add("关羽");
        String names = "";
        for (int i = 0; i < users.size(); i++) {
            names += users.get(i) + ",";
        }
        System.out.println(names);
        System.out.println(names.substring(0, names.length() - 1));
    }
}
