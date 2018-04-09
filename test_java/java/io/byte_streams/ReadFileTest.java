package io.byte_streams;

import java.io.*;

/**
 * �ֽ��� ���ļ�����
 */
class ReadFileTest {
    public static void main(String[] args) throws IOException {
        String fileName = "D:" + File.separator + "hello.txt";
        File f = new File(fileName);
        InputStream in = new FileInputStream(f);
        byte[] b = new byte[1024];
        in.read(b);
        in.close();
        System.out.println(new String(b));
    }
}