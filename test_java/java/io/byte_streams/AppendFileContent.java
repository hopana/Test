package io.byte_streams;

import java.io.*;

/**
 * 字节流 向文件中追加新内容：
 */
class AppendFileContent {
    public static void main(String[] args) throws IOException {
        String fileName = "D:" + File.separator + "hello.txt";
        File f = new File(fileName);
        OutputStream out = new FileOutputStream(f, true);
        String str = "Rollen";
        // String str="\r\nRollen"; 可以换行
        byte[] b = str.getBytes();
        for (int i = 0; i < b.length; i++) {
            out.write(b[i]);
        }
        out.close();
    }
}