package io.file;

import java.io.*;

class IsDirectoryTest {
    public static void main(String[] args) {
        String fileName = "D:" + File.separator;
        File f = new File(fileName);
        if (f.isDirectory()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}