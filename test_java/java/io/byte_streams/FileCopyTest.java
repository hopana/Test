package io.byte_streams;

import java.io.*;

/**
 * �ļ��ĸ���
 */
class FileCopyTest {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("�����в���������������");
            System.exit(1);
        }
        File file1 = new File(args[0]);
        File file2 = new File(args[1]);

        if (!file1.exists()) {
            System.out.println("�����Ƶ��ļ�������");
            System.exit(1);
        }
        InputStream input = new FileInputStream(file1);
        OutputStream output = new FileOutputStream(file2);
        if ((input != null) && (output != null)) {
            int temp = 0;
            while ((temp = input.read()) != (-1)) {
                output.write(temp);
            }
        }
        input.close();
        output.close();
    }
}