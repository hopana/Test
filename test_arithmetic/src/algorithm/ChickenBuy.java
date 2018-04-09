package algorithm;

public class ChickenBuy {

    /**
     * 百钱买百鸡问题
     *
     * @param args
     * 我国古代数学家张丘建在 《张丘建算经》一书中提出了“百鸡问题”： 鸡翁一，值钱五，鸡母一，值钱三，鸡雏三，值钱一。
     * 百钱买百鸡，问鸡翁、鸡母、鸡雏各几何？
     */
    static int x;// 可买鸡翁只数
    static int y;// 可买鸡母只数
    static int z;// 可买鸡雏只数

    // 方法一 ：循环列举法
    public static void method1() {
        x = 0;
        while (x <= 19) {
            y = 0;
            while (y <= 33) {
                z = 100 - x - y;
                if (x * 5 + y * 3 + z / 3 == 100 && z % 3 == 0 && x != 0) {
                    System.out.println("可买鸡翁只数:" + x);
                    System.out.println("可买鸡母只数:" + y);
                    System.out.println("可买鸡雏只数:" + z);
                    System.out.println("-------------------");
                }
                y++;
            }
            x++;
        }
    }

    // 方法二：循环法二
    public static void method2() {
        for (int x = 1; x <= 100 / 5; x++) {
            for (int y = 0; y <= 33; y++) {
                z = 100 - x - y;
                if (x * 5 + y * 3 + z / 3 == 100 && z % 3 == 0) {
                    System.out.println("可买鸡翁只数:" + x);
                    System.out.println("可买鸡母只数:" + y);
                    System.out.println("可买鸡雏只数:" + z);
                    System.out.println("-------------------");
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("方法一:");
        method1();
        System.out.println("方法二:");
        method2();
    }
}
