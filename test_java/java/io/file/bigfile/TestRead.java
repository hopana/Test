package io.file.bigfile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.security.AccessController;

import sun.security.action.GetPropertyAction;

public class TestRead {

    public static void main(String[] args) throws IOException {
        // 记录开始运行时间戳
        File filein = new File("D:\\policy_20131017.unl");
        File fileout = new File("D:\\policy_20131017.unl.bin");

        if (!filein.exists() || !filein.isFile()) {
            System.out.println("Wrong FileURL!");
            System.exit(0);
        }

		/*
         * ZONENO 地区号 PIC 9(5) MDCARDNO 卡号 PIC X(19) NAME 客户姓名 PIC X(60)
		 * LGLDOCTP 证件类型 PIC 9(3) LGLDOCNO 证件号码 PIC X(20) ISRSDATE 起保日期（含） PIC
		 * X(10) ISREDATE 终止日期（含） PIC X(10) STATE 保险变动情况 PIC 9(3) NOTES 备用域 PIC
		 * X(30)
		 */

        // 换行符
        String lineSeparator = (String) AccessController.doPrivileged(new GetPropertyAction("line.separator"));

        BigFileReader unlReader = new BigFileReader(filein, "GB18030");

        PrintStream ps = new PrintStream(new BufferedOutputStream(new FileOutputStream(fileout), 1024 * 1024 * 10), true);

        while (unlReader.hasNext()) {
            String read = unlReader.next();
            String[] readl = read.split("\\|");
            System.out.println(read);
            ps.printf("%-5s%-19s%-60s%-3s%-20s%-10s%-10s%-3s%-30s" + lineSeparator, readl[0], readl[1], readl[2], readl[3], readl[4], readl[5], readl[6], readl[7], readl[8]);
        }

        ps.flush();
        ps.close();
    }

}
