package syntax;

public class PassByObject {
    Elephant ele;

    public void func(Elephant e) {
        ele = e;
        ele.setWeight(100);
    }

    public static void main(String[] args) {
        Elephant e = new Elephant(50);
        PassByObject p = new PassByObject();
        p.func(e);

        System.out.println(e.weight);
    }
}


class Elephant {
    int weight;

    public Elephant(int weight) {
        super();
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}