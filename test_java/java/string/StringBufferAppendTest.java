package string;

public class StringBufferAppendTest {

    public static void main(String[] args) {
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        sb2.append("什么狗屁掌上宝！");
        sb1 = sb2;
        System.out.println(sb1 + "");

    }

}
