package io.file;

import java.io.File;
import java.io.IOException;

/**
 * @author HP
 * @version 1.0
 * @comment： 获取文件路径
 * @created 2015-12-13 下午4:18:39
 */
public class GetFileFullPath {
    public static void main(String[] args) {
        try {
            File dir = new File("D:\\test\\testpath\\");
            dir.mkdirs();

            File file = new File(dir + "test.txt");
            file.createNewFile();

            System.out.println(file.getAbsolutePath());
            System.out.println(file.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
