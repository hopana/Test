package algorithm;

public class GetFactor {

    public void fengjie(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                System.out.print(i + "*");
                fengjie(n / i);
            }
        }
        System.out.print(n);
        System.exit(0);//不能少这句，否则结果会出错
    }

    public static void main(String[] args) {
        GetFactor c = new GetFactor();
        String str = javax.swing.JOptionPane.showInputDialog("请输入N的值（输入exit退出）：");
        int N = 0;
        try {
            N = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        System.out.print(N + "分解质因数：" + N + "=");
        c.fengjie(N);
    }
}