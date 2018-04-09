package reflection;

import java.lang.reflect.Field;
import java.util.Date;

public class TestGetFieldType {
    public static void main(String[] args) {
        Person mike = new Person("mike", "male", new Date());
        Field field = null;
        Class classFieldType = null;
        try {
            field = mike.getClass().getDeclaredField("birthDate");
            classFieldType = field.getType();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        if (classFieldType == java.sql.Date.class) {
            System.out.println("sql:" + classFieldType.getClass().getName());
        } else if (classFieldType == java.util.Date.class) {
            System.out.println("util:" + classFieldType.getCanonicalName());
        }
    }
}

class Person {
    String name;
    String sex;
    Date birthDate;

    public Person(String name, String sex, Date birthDate) {
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
    }
}
