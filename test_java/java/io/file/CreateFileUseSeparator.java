package io.file;

import java.io.File;

public class CreateFileUseSeparator {
    public static void main(String[] args) {
        String fileName = "D:" + File.separator + "HelloWorld.txt";
        File f = new File(fileName);
        try {
            f.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}