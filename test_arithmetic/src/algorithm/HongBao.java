package algorithm;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author HP
 * @version 1.0
 * @comment： 抢红包算法
 * @created 2016-03-07 15:42:24
 */
public class HongBao {
    public static void main(String[] args) {
        double amount = 100;
        int count = 10;

        List<Double> list = getHongBao(amount, count);

        DecimalFormat df = new DecimalFormat("#0.00");

        for (double d : list) {
            System.out.println(df.format(d));
        }

    }

    private static List getHongBao(double amount, int count) {
        LinkedList<Double> list = new LinkedList<Double>();

        double AVG = amount / count;
        double MAX = amount / 4;
        double MIN = 0.01;

        double money = 0.00;
        double leftMoney = amount;
        int leftCount = 0;
        boolean hasBest = false;

        for (int i = 0; i < count - 1; i++) {
            money = getMoney(amount);

            if (!hasBest) {
                while (money > MAX || money < MIN) {
                    money = getMoney(amount);
                }
            } else {
                if (leftMoney / leftCount < AVG) {
                    while (money > AVG || money < MIN) {
                        money = getMoney(amount);
                    }
                } else {
                    while (money < MIN) {
                        money = getMoney(amount);
                    }
                }
            }

            if (money > AVG * 2) {
                hasBest = true;
            }

            money = new BigDecimal(money).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            leftMoney = new BigDecimal(leftMoney - money).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

            leftCount--;
            list.add(money);
        }

        list.add(leftMoney);

        return list;
    }

    private static double getMoney(double amount) {
        Random random = new Random();
        return random.nextInt((int) amount) + random.nextDouble();
    }

}
