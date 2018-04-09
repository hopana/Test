package io.file;

import java.io.File;

class CreateFile {
    public static void main(String[] args) {
        File f = new File("D:\\hello.txt");
        try {
            f.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
