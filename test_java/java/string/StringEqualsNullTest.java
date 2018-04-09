package string;

public class StringEqualsNullTest {
    public static void main(String[] args) {
        String username = null;
        if ("Michael".equals(username)) {
            System.out.println("hello Michael");
        }

        // 下面这么写可能会报错
//		if(username.equals(username)){
//			System.out.println("hello Michael");
//		}
    }
}
