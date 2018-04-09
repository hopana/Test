package string;

import java.util.StringTokenizer;

public class StringTokenizerTest {
    public static void main(String[] args) {
        String s1 = "200926240140   计科院 软工  0901班   男   胡盼";
        String s2 = "200926240140/计科院 软工/0901班/男 /胡盼";
        StringTokenizer st1 = new StringTokenizer(s1);
        StringTokenizer st2 = new StringTokenizer(s1);
        StringTokenizer st3 = new StringTokenizer(s2, "/", false);
        StringTokenizer st4 = new StringTokenizer(s2, "/", true);
        while (st1.hasMoreTokens()) {
            System.out.println(st1.nextToken());
        }
        System.out.println("------------------");
        st2.nextToken();
        st2.nextToken();
        st2.nextToken();
        String sex = st2.nextToken();
        String name = st2.nextToken();
        System.out.println("name:" + name + "  sex:" + sex);
        System.out.println("------------------");
        while (st3.hasMoreTokens()) {
            System.out.println(st3.nextToken());
        }
        System.out.println("------------------");
        while (st4.hasMoreTokens()) {
            System.out.println(st4.nextToken());
        }
    }
}
