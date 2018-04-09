package io.char_streams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    public static void main(String[] args) {
        String path = "C:/Users/Administrator/Desktop/1215.sql";
        // 定义文件路径
        try {
            String content = readFile(path);
            System.out.println("文件内容：\n" + content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * 读取指定的文本文件，并返回内容 　
     * @parampath文件路径 　　
     * @return文件内容
     * @throwsIOException如果文件不存在、打开失败或读取失败 　　
     */
    private static String readFile(String path) throws IOException {
        String content = "";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = reader.readLine()) != null) {
                content += line + "\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // 关闭Reader出现的异常一般不需要处理。
                }
            }
        }
        return content;
    }
}
