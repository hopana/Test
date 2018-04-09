package io.file;

import java.io.*;

/**
 * �г�ָ��Ŀ¼��ȫ������
 */

class SearchAllFiles {
    public static void main(String[] args) {
        String fileName = "D:" + File.separator;
        File f = new File(fileName);
        print(f);
    }

    public static void print(File f) {
        if (f != null) {
            if (f.isDirectory()) {
                File[] fileArray = f.listFiles();
                if (fileArray != null) {
                    for (int i = 0; i < fileArray.length; i++) {
                        // �ݹ����
                        print(fileArray[i]);
                    }
                }
            } else {
                System.out.println(f);
            }
        }
    }
}