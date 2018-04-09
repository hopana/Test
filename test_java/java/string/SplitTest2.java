package string;

public class SplitTest2 {

    public static void main(String[] args) {
        String tripMember = "598,483";
        String[] ids = tripMember.split(",");
        for (int i = 0; i < ids.length; i++) {
            System.out.println("---" + ids[i] + "---");
        }
    }
}
