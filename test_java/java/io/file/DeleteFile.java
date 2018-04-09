package io.file;

import java.io.*;

/**
 * 删除一个文件
 */
class DeleteFile {
    public static void main(String[] args) {
        String fileName = "D:" + File.separator + "HelloWorld.txt";
        File f = new File(fileName);
        if (f.exists()) {
            f.delete();
        } else {
            System.out.println("文件不存在");
        }

    }
}
