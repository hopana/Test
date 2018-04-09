package test;

public class NullTest {
    public static void main(String[] args) {
        Person p = null;
        if (p != null) {
            System.out.println("p 不是NULL...");
        } else {
            System.out.println("p 为NULL...");
        }
        if (p.getName() != null) {
            System.out.println("p有名字...");
        }
    }
}

class Person {
    public String name;
    public String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }
}