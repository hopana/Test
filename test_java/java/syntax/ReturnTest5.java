package syntax;

public class ReturnTest5 {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            //
        } finally {
            return;
        }
    }
}
