package test;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    public static List<Phone> list = null;

    public static void add() {
        list = new ArrayList<Phone>();
        for (int i = 0; i < 3; i++) {
            list.add(new Phone("phone", i));
        }
    }

    public static void main(String[] args) {
        add();
        add();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getAge());
        }
    }
}

class Phone {
    public String name;
    public int age;

    public Phone(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}