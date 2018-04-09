package io.byte_streams;

import java.io.*;

/*
 * 字节流
 * 读文件
 * 
 */
class ReadFile5 {
    public static void main(String[] args) throws IOException {
        String fileName = "D:" + File.separator + "hello.txt";
        File f = new File(fileName);
        InputStream in = new FileInputStream(f);
        byte[] b = new byte[1024];
        int count = 0;
        int temp = 0;
        while ((temp = in.read()) != (-1)) {
            b[count++] = (byte) temp;
        }
        in.close();
        System.out.println(new String(b));
    }
}