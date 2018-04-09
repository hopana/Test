package io.buffer_read_write;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

public class BufferReaderWriter {
    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedInputStream bis = null;
        try {
            br = new BufferedReader(new FileReader("D:/test.txt"));
            br = new BufferedReader(new InputStreamReader(new FileInputStream("D:/test.txt")));

            bis = new BufferedInputStream(new FileInputStream("D:/test.txt"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
