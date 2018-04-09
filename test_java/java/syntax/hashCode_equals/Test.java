package syntax.hashCode_equals;

public class Test {

    public static void main(String[] args) {
        People p1 = new People("王五", "18603043735", "深圳", 25);
        People p2 = new People("王五", "13804732343", "北京", 40);

        System.out.println(p1 == p2);
        System.out.println("---------------------------");
        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode() == p2.hashCode());

        System.out.println("=========================================");

        Dog dog1 = new Dog("ahuang", 3);
        Dog dog2 = dog1;

        System.out.println(dog1.equals(dog2));
    }
}
