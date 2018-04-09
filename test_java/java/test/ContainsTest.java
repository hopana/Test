package test;

import java.util.ArrayList;
import java.util.List;

public class ContainsTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("2012-3");
        list.add("2012-1");
        list.add("2012-7");
        if (list.contains("2012-1")) {
            System.out.println("Yes!");
        }
    }
}
