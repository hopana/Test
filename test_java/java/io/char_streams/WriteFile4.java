package io.char_streams;

import java.io.*;

/**
 * 字符流 写入数据
 */
class WriteFile4 {
    public static void main(String[] args) throws IOException {
        String fileName = "D:" + File.separator + "hello.txt";
        File f = new File(fileName);
        Writer out = new FileWriter(f);
        String str = "hello海云天";
        out.write(str);
        out.close();
    }
}