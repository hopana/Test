package function;

public class FunctionCallTest {

    String s = "null";

    public String f1(String s) {
        s = "change1";
        return s;
    }

    public String f2(String s) {
        s = "change2";
        return s;
    }

    public static void main(String[] args) {
        FunctionCallTest function = new FunctionCallTest();
        function.f1(function.s);
        function.f2(function.s);
        System.out.println(function.s);
    }
}
