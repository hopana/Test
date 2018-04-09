package string;

public class StringBufferTest {
    public static void main(String[] args) {
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        sb1.append("深圳市南山区白石洲上白石一坊45号307室");
        sb2.append("深圳市南山区科技园科发路10号维用科技大厦301室");
        sb1.append(sb2);
        System.out.println(sb1 + "");
    }
}
