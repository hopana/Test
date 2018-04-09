package io.file;

import java.io.File;
import java.util.LinkedList;

public class ScanDir1 {
    public static void main(String[] args) {
        ScanDir1.scanDirNoRecursion("C:\\Program Files (x86)");
    }

    // 非递归实现遍历文件夹
    public static void scanDirNoRecursion(String path) {
        //构造一个	LinkedList 用来放非文件的路径
        LinkedList<File> list = new LinkedList<File>();

        File dir = new File(path);
        File[] file = dir.listFiles();
        for (int i = 0; i < file.length; i++) {
            if (file[i].isDirectory())
                list.add(file[i]);
            else {
                System.out.println(file[i].getAbsolutePath());
            }
        }
        File tmp;
        while (!list.isEmpty()) {
            tmp = (File) list.removeFirst();// 首个目录
            if (tmp.isDirectory()) {
                file = tmp.listFiles();
                if (file == null)
                    continue;
                for (int i = 0; i < file.length; i++) {
                    if (file[i].isDirectory())
                        list.add(file[i]);// 目录则加入目录列表，关键
                    else {
                        System.out.println(file[i]);
                    }
                }
            } else {
                System.out.println(tmp);
            }
        }
    }

}
