package io.byte_streams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * �ļ��ĸ���
 */
class FileCopyByCharBuffer {
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
            in = new BufferedReader(new FileReader(file1));
            out = new BufferedWriter(new FileWriter(file2));
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