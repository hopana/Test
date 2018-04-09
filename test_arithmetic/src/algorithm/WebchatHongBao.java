package algorithm;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author HP
 * @version 1.0
 * @comment： 微信红包算法
 * @created 2016-03-07 22:34:55
 */
public class WebchatHongBao {
    public static void main(String[] args) {
        List<Double> list = QiangHongBao(100, 11);
        DecimalFormat df = new DecimalFormat("#0.00");

        BigDecimal sum = new BigDecimal(0.00);

        for (Double money : list) {
            sum = sum.add(new BigDecimal(money));
            System.out.printf("%5s\n", df.format(money));
        }

        System.out.println("抢到的红包总和：" + sum.doubleValue());
    }

    public static List<Double> QiangHongBao(double amount, int size) {
        LinkedList<Double> list = new LinkedList<Double>();

        double remainMoney = amount;
        int remainSize = size;

        double money, min = 0.01, max;
        Random r = new Random();

        for (int i = 0; i < size; i++) {

            if (remainSize == 1) {
                money = remainMoney;
            } else {
                max = remainMoney / remainSize * 2;
                money = r.nextDouble() * max;
                money = money <= min ? 0.01 : money;
            }

            money = new BigDecimal(money).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            list.add(money);

            remainSize--;
            remainMoney -= money;

        }

        return list;

    }

}
