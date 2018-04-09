package io.char_streams;

import java.io.*;

/**
 * 将字节输出流变为字符输出流
 */

public class OutByteToChar {
    public static void main(String[] args) throws IOException {
        String fileName = "d:" + File.separator + "hello.txt";
        File file = new File(fileName);
        Writer out = new OutputStreamWriter(new FileOutputStream(file));
        out.write("hello");
        out.close();
    }
}