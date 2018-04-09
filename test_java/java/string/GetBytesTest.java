package string;

public class GetBytesTest {
    public static void main(String[] args) {
        String s = "Welcom You!";
        byte[] bs = s.getBytes();
        for (byte b : bs) {
            System.out.println(b);
        }
    }
}
