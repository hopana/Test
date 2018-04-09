package io.byte_streams;

import java.io.*;

/**
 * 字节流 读文件内容,节省空间
 */
class ReadFile3 {
    public static void main(String[] args) throws IOException {
        String fileName = "D:" + File.separator + "test.txt";
        File f = new File(fileName);
        InputStream in = new FileInputStream(f);
        byte[] b = new byte[(int) f.length()];
        in.read(b);
        System.out.println("文件长度为：" + f.length());
        in.close();
        System.out.println(new String(b));
    }
}