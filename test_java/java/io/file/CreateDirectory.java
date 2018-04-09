package io.file;

/**
 * 创建一个文件夹
 */

import java.io.*;

class CreateDirectory {
    public static void main(String[] args) {
        String fileName = "D:" + File.separator + "hello";
        File f = new File(fileName);
        f.mkdir();
    }
}