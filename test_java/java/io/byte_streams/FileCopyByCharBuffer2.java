package io.byte_streams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * �ļ��ĸ���
 */
class FileCopyByCharBuffer2 {
    public static void main(String[] args) {
        File file1 = new File("D:/test.txt");
        File file2 = new File("D:/test_copy_by_char_readLine.txt");

        if (!file1.exists()) {
            System.out.println("�����Ƶ��ļ�������");
            System.exit(1);
        }

        BufferedReader in = null;
        BufferedWriter out = null;

        String temp = "";

        try {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(file1)));
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2)));
            while ((temp = in.readLine()) != null) {
                out.write(temp);
                out.newLine();
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