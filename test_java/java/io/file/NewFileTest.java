package io.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class NewFileTest {
    public static void main(String[] args) {

        File file = new File("c:/test.txt");
        InputStream is;
        try {
            is = new FileInputStream(file);
            File deskFile = new File("C:/foo", "xxxxxxx.txt");
            OutputStream os = new FileOutputStream(deskFile);
            byte[] bytefer = new byte[1024];
            int length = 0;
            try {
                while ((length = is.read(bytefer)) != -1) {
                    os.write(bytefer, 0, length);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                os.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
