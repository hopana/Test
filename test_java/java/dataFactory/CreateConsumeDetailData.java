package dataFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class CreateConsumeDetailData {
    public static void main(String[] args) {
        File file = new File("d:\\CosumeDetailData.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        for (int i = 0; i <= 2500; i++) {
            int j = 2570523 + i;
            double n = 26000 + Math.random() * 1000;
            DecimalFormat df = new DecimalFormat("#0.00");
            df.setMaximumIntegerDigits(30);
            String m = df.format(n);
            String s = "6282080000248895                                            " + j + "                                                     10210003                                          847314                                  816549              011217845649        2012110909205820121110潍坊银行山东地区                                            青岛柜面通还款        QING DAO     CN                                                                                   " + m + "       " + m + "       8600200060109998                   15615604624580            04624580            0302                00254996            10";
            try {
                fw.write(s);
                fw.write("\r\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
