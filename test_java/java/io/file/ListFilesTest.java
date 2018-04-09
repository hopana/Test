package io.file;

import java.io.File;

public class ListFilesTest {
    public static void main(String[] args) {
        File file = new File("D:\\0000\\");
        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f.getName());
        }
    }
}
