package collection;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TestTreeSet {

    public static void main(String[] args) {
        Set<Object> set = new TreeSet<Object>();
        Set<Object> set2 = new TreeSet<Object>(new BigFatComparator());

        set.add(new Fat("1", 1));
        set.add(new Fat("2", 2));
        set.add(new Fat("3", 3));
        set.add(new Fat("4", 4));

        set2.add(new BigFat("1", 1, 75));
        set2.add(new BigFat("2", 2, 60));
        set2.add(new BigFat("3", 3, 80));
        set2.add(new BigFat("4", 4, 70));

        for (Object o : set) {
            System.out.println(o.toString());
        }

        System.out.println("----------------------");

        for (Object o : set2) {
            System.out.println(o.toString());
        }

    }

}


class Fat implements Comparable<Fat> {
    String name;
    int age;

    public Fat() {

    }

    public Fat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Fat o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "name:" + name + " age:" + age;
    }

}

class BigFat {
    String name;
    int age;
    int weight;

    public BigFat() {

    }

    public BigFat(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "name:" + name + " age:" + age + " weight:" + weight;
    }

}

class BigFatComparator implements Comparator<Object> {

    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof BigFat && o2 instanceof BigFat) {
            BigFat fat1 = (BigFat) o1;
            BigFat fat2 = (BigFat) o2;

            return fat1.weight - fat2.weight;
        }

        return 0;
    }
}