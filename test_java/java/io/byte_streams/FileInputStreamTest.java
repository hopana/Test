package io.byte_streams;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:/test.txt");
        byte[] buf = new byte[512];
        int read = 0;

        while ((read = fis.read(buf)) > 0) {
            System.out.println(new String(buf, 0, read));
        }
        fis.close();
    }
}
