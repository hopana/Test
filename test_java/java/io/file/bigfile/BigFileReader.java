package io.file.bigfile;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 本类，是专门为了处理大文件，按行读取开发的类。 采用读文件的缓存 fbb 1024*5 行缓存 bb 256
 * 字节设计思想： 每次通过nio读取字节到fbb中 然后对fbb自己中的内容进行行判断即 10 回车 13 行号 0 文件结束 这样字节的判断，然后 返回行
 * 如果到达fbb的结尾还没有结束，就再通过nio读取一段字节，继续处理。
 * 由于对于本程序 116个字节以上的行才有意义，所以在next实现方法中，有对116长度的判断，否则返回 null
 */
public class BigFileReader {

    private File file = null;
    Charset charset = Charset.forName("GB2312");

    RandomAccessFile raf = null;
    FileChannel fc = null;

    public BigFileReader(File file, String charset) throws IOException {
        this.file = file;
        this.charset = Charset.forName(charset);

        raf = new RandomAccessFile(this.file, "r");

        init();
    }

    public BigFileReader(String file, String charset) throws IOException {
        this(new File(file), charset);
    }

    private void init() throws IOException {
        // 136+2 一个完整 命令的最大字节数
        fc = raf.getChannel();
        fc.read(fbb);
        fbb.flip();
    }

    /**
     * 每行缓存的字节
     */
    ByteBuffer bb = ByteBuffer.allocate(256);
    /**
     * 一次读取文件，读取的字节缓存数
     */
    ByteBuffer fbb = ByteBuffer.allocate(1024 * 5);
    boolean EOF = false;

    public boolean hasNext() throws IOException {
        /*
		 * 通过一个环的形式，处理数据 bb 做为一行数据的缓存区 fbb 是读取出来的 缓存区的内容 判断是否包含数据，如果数据为空，则启动线程获取一段数据
		 */
        if (EOF)
            return false;
        if (fbb.position() == fbb.limit()) {
            if (readByte() == 0)
                return false;
        }
        while (true) {
            if (fbb.position() == fbb.limit()) {
                if (readByte() == 0)
                    break;
            }
            byte a = fbb.get();
            if (a == 13 || a == 10 || a == 0) {
                if (fbb.position() == fbb.limit()) {
                    if (readByte() == 0)
                        break;
                }
                if (fbb.get() == 10) {

                } else {
                    fbb.position(fbb.position() - 1);
                }
                return true;
            } else {
                bb.put(a);
            }
        }
        return true;
    }

    private int readByte() throws IOException {
        fbb.rewind();
        fbb.clear();
        if (this.fc.read(fbb) == -1) {
            EOF = true;
            return 0;
        } else {
            fbb.flip();
            return fbb.limit();
        }
    }

    public String next() {
        bb.flip();
        byte tm[] = ArrayUtils.subarray(bb.array(), bb.position(), bb.limit());
        bb.clear();
        return new String(ArrayUtils.subarray(tm, 0, tm.length), this.charset);
    }

    ;

    @Override
    protected void finalize() throws Throwable {
        this.file = null;
        super.finalize();
    }

}
