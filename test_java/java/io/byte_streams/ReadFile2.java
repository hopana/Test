package io.byte_streams;

import java.io.*;

/**
 * 字节流 读文件内容
 */
class ReadFile2 {
    public static void main(String[] args) throws IOException {
        String fileName = "D:" + File.separator + "test.txt";
        File f = new File(fileName);
        InputStream in = new FileInputStream(f);
        byte[] b = new byte[512];
        int len = in.read(b);
        in.close();
        System.out.println("读入长度为：" + len);
        System.out.println(new String(b, 0, len));
    }
}