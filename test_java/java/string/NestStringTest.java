package string;

public class NestStringTest {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("<?xml version=\"1.0\" encoding=\"GBK\"?>\n");
        sb.append("<root xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">");
        System.out.println(sb);
    }
}
