package convertor;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class EncodingConvertor {

    /**
     * �����ࣺת��Java�ļ�����
     */
    public static void main(String[] args) {
        System.out.print("������Ҫת�����ļ���·����");
        Scanner scan = new Scanner(System.in);
        String path = scan.nextLine();
        System.out.print("�������ת���ļ���ԭʼ���룺");
        String encoding1 = scan.nextLine();
        System.out.print("�������ת���ļ����±��룺");
        String encoding2 = scan.nextLine();
        //convertor(path,encoding1,encoding2);

    }

    public static void convertor(String path, String oriEncoding, String newEncoding) {
        File f = new File(path);
        if (f != null) {
            if (f.isDirectory()) {
                File[] fileArray = f.listFiles();
                if (fileArray != null) {
                    for (int i = 0; i < fileArray.length; i++) {
                        // �ݹ����
                        //convert(fileArray[i]);
                    }
                }
            } else {
                System.out.println(f);
            }
        }
    }

    public static void doConvert(File f) {
        if (f != null) {
            if (f.isDirectory()) {
                File[] fileArray = f.listFiles();
                if (fileArray != null) {
                    for (int i = 0; i < fileArray.length; i++) {
                        // �ݹ����
                        doConvert(fileArray[i]);
                    }
                }
            } else {
                //FileInputStrem fis = new FileInputStream(f);
            }
        }
    }

}
