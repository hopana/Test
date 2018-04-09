package io.byte_streams;

import java.io.*;

/**
 * 字节流 读文件内容,节省空间
 */
class ReadFile4 {
    public static void main(String[] args) throws IOException {
        String fileName = "D:" + File.separator + "test.txt";
        File f = new File(fileName);
        InputStream in = new FileInputStream(f);
        byte[] b = new byte[(int) f.length()];
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) in.read();
        }
        in.close();
        System.out.println(new String(b));
    }
}