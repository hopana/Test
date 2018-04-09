package bigdata;

import java.io.File;

/**
 * Notice:
 * <BR> 1. 仅限使用以下package:
 * java.lang.*, java.io.*, java.math.*, java.text.*, java.util.*
 * <BR> 2. 请勿变更 package名，类名，test()定义。
 */
public class ProgramTest {

    /**
     * 请在此方法内完成代码，但可以增加自己的私有方法。
     * 数据文件inputFile的内容格式为一行一条数据，每条数据有2个字段用逗号分隔，第1个字段为排序用的Key，第二个字段为value。
     * 换行符为'\n'。
     * 数据内容举例如下:
     * abe,xmflsflmfmlsmfs
     * abc,xmlmxlkmffhf
     * 8fj3l,xxjfluu313ooo11
     * <p>
     * 注意点: 1.本次的测试数据内容都是ASCII字符，无中文汉字.所以不必考虑encoding。
     * 2.本次的测试数据中,key的最大长度8，value的最大长度32。
     * <p>
     * 排序以key的升序，使用String.compareTo()来比较key的大小。最后排序完成的数据写入outputFile。
     *
     * @param inputFile  输入文件
     * @param outputFile 输出文件
     * @param tempFile   临时文件。处理的数据量大的时候，可能会需要用到临时文件。
     * @throws Exception
     */
    public static void test(File inputFile, File outputFile, File tempFile) throws Exception {
        // TODO ====================== YOUR CODE HERE ======================

        // =================================================================
    }

    // TODO ====================== YOUR CODE HERE (You can add private method if
    // need) ======================
//    public int memory_sort(File file) {
//        FILE * fin = fopen(m_in_file, "rt");
//        int n = 0, file_count = 0;
//            int *array = new int[m_count];
//        //每读入m_count个整数就在内存中做一次排序，并写入临时文件
//        while ((n = read_data(fin, array, m_count)) > 0) {
//            qsort(array, n, sizeof(int),cmp_int);
//                    char *fileName = temp_filename(file_count++);
//            FILE * tempFile = fopen(fileName, "w");
//            free(fileName);
//            write_data(tempFile, array, n);
//            fclose(tempFile);
//        }
//        delete[] array;
//        fclose(fin);
//
//        return file_count;
//    }

    // =================================================================
}
