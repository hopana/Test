package io.file;

import java.io.*;

class ListFileWithPath {
    public static void main(String[] args) {
        String fileName = "D:" + File.separator;
        File f = new File(fileName);
        File[] str = f.listFiles();
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
}