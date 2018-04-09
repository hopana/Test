package convertor;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * ����������ת������ı���.�������ļ����估����
 */
public class Convertor extends AbstractConvertor {

    @Override
    public void convert(String encoding1, String encoding2, String sourcePath, String newPath) {
        if (valid(encoding1, encoding2, sourcePath, newPath)) {
            List<File> list = getFileList(sourcePath);
//			for(File file : list){
//				String realPaht = file.getAbsolutePath();
//				String fileName = file.getAbsolutePath().substring(2,file.getAbsolutePath().length());
//			}
        } else {
            System.out.println("����ת������ʼ��ʧ�ܣ�����ϸ��ò�����");
        }

    }

    public boolean valid(String encoding1, String encoding2, String sourcePath, String newPath) {
        Boolean flag = true;
        if (encoding1 == null || "".equals(encoding1)) {
            System.out.println("������ԭʼ���룡");
            flag = false;
        }
        if (encoding2 == null || "".equals(encoding2)) {
            System.out.println("�������±��룡");
            flag = false;
        }
        File file = new File(sourcePath);
        if (!file.isDirectory()) {
            System.out.println("����·�������ڣ�");
            flag = false;
        }

        return flag;
    }

    public List<File> getFileList(String dir) {
        File dataDir = new File(dir);
        File[] dataFiles = dataDir.listFiles();
        List<File> list = new ArrayList<File>();
        try {
            for (int i = 0; i < dataFiles.length; i++) {
                // �����Ŀ¼��ݹ���ô˷���.��������
                if (dataFiles[i].isDirectory()) {
                    getFileList(dataFiles[i].getCanonicalPath());
                } else {
                    // �ļ�����,���������ע�ʹ˴�����
                    if (dataFiles[i].isFile()
                            && (dataFiles[i].getName().endsWith(".jsp") || dataFiles[i].getName().endsWith(".html") || dataFiles[i]
                            .getName().endsWith(".htm")) || dataFiles[i].getName().endsWith(".js")
                            || dataFiles[i].getName().endsWith(".java")) {
                        list.add(dataFiles[i]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
        return list;
    }

    public boolean writeFile(String realPath, String fileName) {
        boolean isOK = false;
        String templet = realPath;
        String newFile = "D:/NewFiles/" + fileName.substring(1, fileName.length());
        makeDir(newFile);
        String templateContent = "";

        // ��ȡ�ļ�����.������UTF-8��ȡ.����readFileUTF8(filePath)����
        templateContent = readFile(templet);

        // �������ҳ������ע���˱�����ļ�.�ô˷����滻
        templateContent = templateContent.replaceAll("gb2312", "UTF-8");
        templateContent = templateContent.replaceAll("gbk", "UTF-8");

		/*
         * templateContent = templateContent.replaceAll("UTF-8", "GBK");
		 * templateContent = templateContent.replaceAll("utf-8", "GBK");
		 */
        // templateContent = templateContent.replaceAll("GB2312", "UTF-8");
        // templateContent = templateContent.replaceAll("gbk", "UTF-8");
        // System.out.println("���:" + templateContent);
        isOK = writeNewFile(newFile, templateContent);
        System.out.println("���:" + newFile);
        return isOK;
    }

    // ��Ĭ�ϱ����ȡ�ļ�����.�����ַ�������
    private String readFile(String templet) {
        String templetContent = "";
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(templet);
            int length = fis.available();
            byte[] bytes = new byte[length];
            fis.read(bytes);
            templetContent = new String(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return templetContent;
    }

    // ��UTF-8��ȡ�ļ�����.�����ַ�������
    private String readFileUTF8(String templet) {
        String templetContent = "";
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(templet);
            int length = fis.available();
            byte bytes[] = new byte[length];
            fis.read(bytes);
            templetContent = new String(bytes, "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return templetContent;
    }

    // �����ļ��н�����ͬ��Ŀ¼�ṹ
    private void makeDir(String path) {
        File fileStr = new File(path);
        File file = new File(fileStr.getParent());
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    /**
     * ��UTF-8��ʽд���ļ�
     *
     * @param newFile
     * @param templetContent
     * @return
     */
    private boolean writeNewFile(String newFile, String templetContent) {
        boolean isOK = false;
        FileOutputStream fos = null;
        OutputStreamWriter out = null;
        try {
            fos = new FileOutputStream(newFile);
            out = new OutputStreamWriter(new BufferedOutputStream(fos), "UTF-8");
            out.write(templetContent);
            isOK = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return isOK;
    }

    public static void main(String[] args) {
        String encoding1 = "UTF8";
        String encoding2 = "GBK";
        String sourcePath = "D:/src";
        String newPath = "D:/newFiles";
        Convertor c = new Convertor();
        c.convert(encoding1, encoding2, sourcePath, newPath);
    }
}