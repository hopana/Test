package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsComparator {

    public static void main(String[] args) {
        People p1 = new People("曹超", "男", 45);
        People p2 = new People("周瑜", "男", 30);
        People p3 = new People("刘备", "男", 48);
        People p4 = new People("孙权", "男", 35);
        List<People> list = new ArrayList<People>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);

        Collections.sort(list, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return o1.age - o2.age;
            }
        });

        for (People p : list) {
            System.out.println(p.toString());
        }
    }

}

class People {
    String name;
    String gender;
    int age;

    public People(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String toString() {
        return "[" + name + "," + gender + "," + age + "]";
    }


}