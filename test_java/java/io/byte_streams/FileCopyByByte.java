package io.byte_streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * �ļ��ĸ��ƣ��ֽ���
 */
class FileCopyByByte {
    public static void main(String[] args) throws IOException {
        File file1 = new File("D:/test.txt");
        File file2 = new File("D:/test_copy_by_byte.txt");

        fileCopy(file1, file2);
    }

    public static void fileCopy(File file1, File file2) {
        if (!file1.exists()) {
            System.out.println("�����Ƶ��ļ�������");
            System.exit(1);
        }
        InputStream input = null;
        ;
        OutputStream output = null;
        try {
            input = new FileInputStream(file1);
            output = new FileOutputStream(file2);

            int temp = 0;
            byte[] buf = new byte[512];

            while ((temp = input.read(buf)) != (-1)) {
                output.write(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("���Ƴɹ���");
        }
    }
}