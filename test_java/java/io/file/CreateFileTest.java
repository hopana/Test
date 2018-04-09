package io.file;

import java.io.File;

class CreateFileTest {
    public static void main(String[] args) {
        File f = new File("D:\\1\\2");
        try {
            f.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
