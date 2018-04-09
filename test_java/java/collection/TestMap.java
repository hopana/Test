package collection;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        Map map = new HashMap<String, Person>();
        map.put("hupan", new Person("��", 25));
        map.put("tianjuan", new Person("Ů", 21));

        if (map.containsKey("hupan")) {
            Person p = (Person) map.get("hupan");
            p.setGender("Ů");
            p.setAge(100);
        }

        for (Object o : map.keySet()) {
            System.out.println("key:" + (String) o);
            Person person = (Person) map.get(o);
            System.out.println("value:[" + person.getGender() + "," + person.getAge() + "]");
        }
    }
}

class Person {
    String gender;
    int age;

    public Person(String gender, int age) {
        this.gender = gender;
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}