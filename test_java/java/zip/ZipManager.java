package zip;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * �������ڲ���JAVA��ZIPѹ������ѹ
 *
 * @author Sunny Lee (2008-1-4)
 * @version 1.0
 */
public class ZipManager {

    /**
     * zipѹ�����ܲ���. ��d:\\temp\\zipoutĿ¼�µ������ļ���ͬ��Ŀ¼ѹ����d:\\temp\\out.zip.
     * �˷����ɱ�����ѹ���ļ���Ŀ¼�ṹ
     *
     * @param baseDir     ��Ҫѹ����Ŀ¼������������·����
     * @param objFileName ѹ������ļ���
     * @throws Exception
     */
    public void createZip(String baseDir, String objFileName) throws Exception {
        File folderObject = new File(baseDir);

        if (folderObject.exists()) {
            List fileList = getSubFiles(new File(baseDir));

            // ѹ���ļ���
            ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(objFileName));

            ZipEntry ze = null;
            byte[] buf = new byte[1024];
            int readLen = 0;
            for (int i = 0; i < fileList.size(); i++) {
                File f = (File) fileList.get(i);
                System.out.println("Adding: " + f.getPath() + f.getName());

				/*
                 * ����һ��ZipEntry��������Name��������һЩ����
				 * ע�⣬��ZipEntry�ǰ���Ŀ¼�ṹ�ģ��˹�������getAbsFileName(String,string)��ɵ�
				 */
                ze = new ZipEntry(getAbsFileName(baseDir, f));
                ze.setSize(f.length());
                ze.setTime(f.lastModified());

                // ��ZipEntry�ӵ�zos�У���д��ʵ�ʵ��ļ�����
                zos.putNextEntry(ze);
                InputStream is = new BufferedInputStream(new FileInputStream(f));
                while ((readLen = is.read(buf, 0, 1024)) != -1) {
                    zos.write(buf, 0, readLen);
                }
                is.close();
                System.out.println("done...");
            }
            zos.close();
        } else {
            throw new Exception("this folder isnot exist!");
        }
    }

    /**
     * ��ĳһ���ļ�����ѹ������������Ŀ¼�������Ŀ¼
     *
     * @param sourceFileName ��ѹ����Ŀ���ļ�����������Ŀ¼�������Ŀ¼
     * @param zipFilename    Ϊѹ������ļ�ָ��������
     * @return ѹ���ļ��Ĵ�С
     * @throws Exception
     */
    public long createFileToZip(String sourceFileName, String zipFilename) throws Exception {

        File sourceFile = new File(sourceFileName);

        byte[] buf = new byte[1024];

        // ѹ���ļ���
        File objFile = new File(zipFilename);

        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(objFile));

        ZipEntry ze = null;
        // ����һ��ZipEntry��������Name��������һЩ����
        ze = new ZipEntry(sourceFile.getName());
        ze.setSize(sourceFile.length());
        ze.setTime(sourceFile.lastModified());

        // ��ZipEntry�ӵ�zos�У���д��ʵ�ʵ��ļ�����
        zos.putNextEntry(ze);

        InputStream is = new BufferedInputStream(new FileInputStream(sourceFile));

        int readLen = -1;
        while ((readLen = is.read(buf, 0, 1024)) != -1) {
            zos.write(buf, 0, readLen);
        }
        is.close();
        zos.close();

        return objFile.length();
    }

    /**
     * ���Խ�ѹ������. ��d:\\download\\test.zip��ͬ��Ŀ¼��ѹ��d:\\temp\\zipoutĿ¼��.
     *
     * @param sourceZip   ����ѹ��zip�ļ�
     * @param outFileName
     * @throws IOException
     */
    public void releaseZipToFile(String sourceZip, String outFileName) throws IOException {
        ZipFile zfile = new ZipFile(sourceZip);
        System.out.println("����ѹ���ļ��ǣ� " + zfile.getName());
        Enumeration zList = zfile.entries();
        ZipEntry ze = null;
        byte[] buf = new byte[1024];
        while (zList.hasMoreElements()) {
            // ��ZipFile�еõ�һ��ZipEntry
            ze = (ZipEntry) zList.nextElement();
            if (ze.isDirectory()) {
                continue;
            }
            // ��ZipEntryΪ�����õ�һ��InputStream����д��OutputStream��
            InputStream is = new BufferedInputStream(zfile.getInputStream(ze));
            OutputStream os = new BufferedOutputStream(new FileOutputStream(getRealFileName(outFileName, ze.getName())));
            int readLen = 0;
            while ((readLen = is.read(buf, 0, 1024)) != -1) {
                os.write(buf, 0, readLen);
            }
            is.close();
            os.close();
            System.out.println("Extracted: " + ze.getName());
        }
        zfile.close();

    }

    /**
     * ȡ��ָ��Ŀ¼�Լ��������Ŀ¼�µ������ļ����б�ע�⣬���ص��б��в���Ŀ¼.
     *
     * @param baseDir File ָ����Ŀ¼
     * @return ����java.io.File��List
     */
    private List getSubFiles(File baseDir) {
        List fileList = new ArrayList();
        File[] tmp = baseDir.listFiles();
        for (int i = 0; i < tmp.length; i++) {
            // ������ļ���ֱ�Ӽ���fileList
            if (tmp[i].isFile()) {
                fileList.add(tmp[i]);
            }
            // �����Ŀ¼���ݹ���ñ��������������������fileList
            if (tmp[i].isDirectory()) {
                fileList.addAll(getSubFiles(tmp[i]));
            }
        }
        return fileList;
    }

    /**
     * ������Ŀ¼������һ�����·������Ӧ��ʵ���ļ���.
     *
     * @param baseDir     ָ����Ŀ¼
     * @param absFileName ���·������������ZipEntry�е�name
     * @return java.io.File ʵ�ʵ��ļ�
     */
    private File getRealFileName(String baseDir, String absFileName) {
        String[] dirs = absFileName.split("/");
        File ret = new File(baseDir);
        // ����Ŀ¼�ṹ
        if (dirs.length > 1) {
            for (int i = 0; i < dirs.length - 1; i++) {
                ret = new File(ret, dirs[i]);
            }
        }
        if (!ret.exists()) {
            ret.mkdirs();
        }
        ret = new File(ret, dirs[dirs.length - 1]);
        return ret;
    }

    /**
     * ������Ŀ¼���ļ���ʵ��·�������ش������·�����ļ���������zip�ļ��е�·��.
     * �罫����·����baseDir\dir1\dir2\file.txt�ĳ� dir1/dir2/file.txt
     *
     * @param baseDir      java.lang.String ��Ŀ¼
     * @param realFileName java.io.File ʵ�ʵ��ļ���
     * @return ����ļ���
     */
    private String getAbsFileName(String baseDir, File realFileName) {
        File real = realFileName;
        File base = new File(baseDir);
        String ret = real.getName();

        while (true) {
            real = real.getParentFile();
            if (real == null)
                break;
            if (real.equals(base))
                break;
            else {
                ret = real.getName() + "/" + ret;
            }
        }
        return ret;
    }

    public static void main(String args[]) {
        ZipManager manager = new ZipManager();
        try {
            //manager.releaseZipToFile("d:\\download\\src.zip", "d:\\temp\\zipout");
            File file = new File("d:\\temp\\zipout\\bak");
            file.delete();
            //manager.createZip("d:\\temp\\zipout", "d:\\temp\\out.zip");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("over");
    }
}
