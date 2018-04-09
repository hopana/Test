package io.byte_streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

public class StreamTest {
    public static void main(String[] args) {
        try {
            InputStream in = new FileInputStream(new File("D:/test.txt"));
            FileOutputStream out = new FileOutputStream(new File("D:/testCopy.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
