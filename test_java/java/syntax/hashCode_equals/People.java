package syntax.hashCode_equals;

public class People {
    String name;
    String tel;
    String addr;
    int age;

    public People(String name, String tel, String addr, int age) {
        this.name = name;
        this.tel = tel;
        this.addr = addr;
        this.age = age;
    }

    public void think() {
        System.out.println(name + "在思考......");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        People other = (People) obj;

        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();

    }
}
