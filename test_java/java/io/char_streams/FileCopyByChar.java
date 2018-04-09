package io.char_streams;

import java.io.*;

public class FileCopyByChar {
    public static void main(String[] args) {
        int b = 0;
        FileReader in = null;
        FileWriter out = null;
        try {
            in = new FileReader("D:/demo.txt");
            out = new FileWriter("D:/demo2.txt");

            while ((b = in.read()) != -1) {
                out.write(b);
            }
            out.close();
            in.close();

        } catch (FileNotFoundException e2) {
            System.out.println("找不到指定文件");
            System.exit(-1);
        } catch (IOException e1) {
            System.out.println("文件复制错误");
            System.exit(-1);
        }
        System.out.println("文件已复制");
    }
}
