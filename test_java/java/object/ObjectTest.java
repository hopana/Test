package object;

public class ObjectTest {
    public static void main(String[] args) {
        Person p = new Person();
        //p.dog.name = "BigYellow";
        p.dog = new Dog();
    }
}

class Person {
    String name;
    String sex;
    int age;
    Dog dog;

    Person() {

    }

    Person(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

}

class Dog {
    String name;
    String nikeName;
    int age;

    Dog() {

    }

    public Dog(String name, String nikeName, int age) {
        this.name = name;
        this.nikeName = nikeName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
