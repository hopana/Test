package syntax;

public class SwitchCaseTest {

    public static void print1(int n) {
        switch (n) {
            case 1:
                System.out.println("1");
            case 2:
                System.out.println("2");
            case 3:
                System.out.println("3");
            case 4:
                System.out.println("4");
            case 5:
                System.out.println("5");
            default:
                System.out.println("default");
        }
    }

    public static void print2(int n) {
        switch (n) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            case 4:
                System.out.println("4");
                break;
            case 5:
                System.out.println("5");
                break;
            default:
                System.out.println("default");
        }
    }

    public static void main(String[] args) {
        print1(1);
        System.out.println("------------------");
        print2(1);
    }

}
