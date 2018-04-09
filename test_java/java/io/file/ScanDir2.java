package io.file;

import java.io.File;

public class ScanDir2 {
    public static void main(String[] args) {
        ScanDir2.scanDirRecursion(new File("C:\\Program Files (x86)"));
    }

    // 递归实现遍历文件夹
    public static void scanDirRecursion(File file) {
        if (file != null) {
            if (file.isDirectory()) {
                File[] fileArray = file.listFiles();
                if (fileArray != null) {
                    for (int i = 0; i < fileArray.length; i++) {
                        // 递归调用
                        scanDirRecursion(fileArray[i]);
                    }
                }
            } else {
                System.out.println(file);
            }
        }
    }

}
