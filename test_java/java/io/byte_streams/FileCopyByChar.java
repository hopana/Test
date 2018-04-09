package io.byte_streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * �ļ��ĸ���
 */
class FileCopyByChar {
    public static void main(String[] args) {
        File file1 = new File("D:/test.txt");
        File file2 = new File("D:/test_copy_by_char.txt");

        if (!file1.exists()) {
            System.out.println("�����Ƶ��ļ�������");
            System.exit(1);
        }

        InputStreamReader in = null;
        OutputStreamWriter out = null;

        try {
            in = new InputStreamReader(new FileInputStream(file1));
            out = new OutputStreamWriter(new FileOutputStream(file2));
            int temp = 0;
            while ((temp = in.read()) != -1) {
                out.write(temp);
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("���Ƴɹ���");
        }
    }
}