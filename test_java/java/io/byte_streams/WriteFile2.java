package io.byte_streams;

import java.io.*;

/**
 * 字节流 向文件中写入字符串
 */
class WriteFile2 {
    public static void main(String[] args) throws IOException {
        String fileName = "D:" + File.separator + "hello.txt";
        File f = new File(fileName);
        OutputStream out = new FileOutputStream(f);
        String str = "你好";
        byte[] b = str.getBytes();
        out.write(b);
        out.close();
    }
}