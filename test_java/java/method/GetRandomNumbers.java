package method;

import java.util.Random;

public class GetRandomNumbers {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(getNumber4());
        }
    }

    // 获取20位的随机数
    public static String getNumber1() {
        String str = "";
        for (int i = 0; i < 20; i++) {
            int num = (int) (Math.random() * 10);
            str = str + String.valueOf(num);
        }
        return str;
    }

    // 获取1到100的随机数
    public static int getNumber2() {
        int num = (int) (new Random().nextInt(100) + 1);
        // for(int i=0;i<10000;i++){
        // System.out.println(new Random().nextInt(100) + 1);
        // }
        return num;
    }

    // 获取6位数的随机数
    public static int getNumber3() {
        // int num = new Random().nextInt(1000000);
        int n = 0;
        while (n > 100000) {
            System.out.println(n);
        }
        return n;
    }

    public static int getNumber4() {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Random rand = new Random();
        for (int i = 10; i > 1; i--) {
            int index = rand.nextInt(i);
            int tmp = array[index];
            array[index] = array[i - 1];
            array[i - 1] = tmp;
        }
        int result = 0;
        for (int i = 0; i < 6; i++)
            result = result * 10 + array[i];
        return result;
    }

}
