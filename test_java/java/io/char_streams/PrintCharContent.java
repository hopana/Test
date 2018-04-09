package io.char_streams;

import java.io.*;

class PrintCharContent {
    public static void main(String[] args) throws IOException {
        String fileName = "d:" + File.separator + "test.txt";
        File file = new File(fileName);
        Reader read = new InputStreamReader(new FileInputStream(file));
        char[] b = new char[100];
        int len = read.read(b);
        System.out.println(new String(b, 0, len));
        read.close();
    }
}