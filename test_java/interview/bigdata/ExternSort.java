package bigdata;

public class ExternSort {
//    int FILE_COUNT = 7;
//    File fin = new File("D:\\test.data");
//    File fout = new File("D:\\testok.data");
//
//    public void sort() {
//        long start = System.currentTimeMillis();
//        // 将文件内容分块在内存中排序，并分别写入临时文件
//        memory_sort(fin);
//        // 归并临时文件内容到输出文件
//        merge_sort(FILE_COUNT);
//        long end = System.currentTimeMillis();
//
//        System.out.printf("total time:%f\n", (end - start) * 1000.0 / 60);
//    }
//
//    // input_file:输入文件名
//    // out_file:输出文件名
//    // count: 每次在内存中排序的整数个数
//    public ExternSort(File input_file, File out_file, int count) {
//        m_count = count;
//        m_in_file = new char[strlen(input_file) + 1];
//        strcpy(m_in_file, input_file);
//        m_out_file = new char[strlen(out_file) + 1];
//        strcpy(m_out_file, out_file);
//    }
//
//    private:
//
//    int m_count; // 数组长度
//    char*m_in_file; // 输入文件的路径
//    char*m_out_file; // 输出文件的路径
//
//    protected int read_data(File f, int a[], int n) {
//        int i = 0;
//        while (i < n && (fscanf(f, "%d", & a[i]) != EOF))i++;
//        printf("read:%d integer\n", i);
//        return i;
//    }
//
//    void write_data(File f, int a[], int n) {
//        for (int i = 0; i < n; ++i)
//            fprintf(f, "%d ", a[i]);
//    }
//
//    char*
//
//    temp_filename(int index) {
//                char *tempfile = new char[100];
//        sprintf(tempfile, "temp%d.txt", index);
//        return tempfile;
//    }
//
//    static int cmp_int(const void *a, const void *b) {
//        return *(int*)a - *(int*)b;
//    }
//
//    public void memory_sort(File fin) {
//        int lineCount = 0;
//        int fileCount = 0;
//        int file_count = 0;
//
//        TreeMap<String, String> map = new TreeMap<String, String>();
//        RandomAccessFile rafin = new RandomAccessFile(fin, "rw");
//
//        String s = null;
//        //每读入m_count个整数就在内存中做一次排序，并写入临时文件
//        while ((s = rafin.readLine()) != null) {
//            String key = s.split(",")[0];
//            String value = s.split(",")[1];
//            map.put(key, value);
//
//            if (++lineCount == 500000) {
//                File file = new File("D:\\test" + fileCount++ + ".data");
//                RandomAccessFile rafout = new RandomAccessFile(fin, "rw");
//                for (Entry<String, String> entry : map.entrySet()) {
//                    rafout.writeBytes(entry.getKey() + "," + entry.getValue());
//                }
//
//                rafout.close();
//                file = null;
//                map.clear();
//                lineCount = 0;
//            }
//        }
//
//        rafin.close();
//        map = null;
//    }
//
//    void merge_sort(int file_count) {
//        if (file_count <= 0) return;
//
//        //归并临时文件
//        FILE * fout = fopen(m_out_file, "wt");
//        File * farray = new File[file_count];
//        int i;
//        for (i = 0; i < file_count; ++i) {
//            char*fileName = temp_filename(i);
//            farray[i] = fopen(fileName, "rt");
//            free(fileName);
//        }
//
//        int *data = new int[file_count];//存储每个文件当前的一个数字
//        bool * hasNext = new bool[file_count];//标记文件是否读完
//        memset(data, 0, sizeof(int) *file_count);
//        memset(hasNext, 1, sizeof(bool) * file_count);
//
//        for (i = 0; i < file_count; ++i) {
//            if (fscanf(farray[i], "%d", & data[i]) ==EOF)//读每个文件的第一个数到data数组
//            hasNext[i] = false;
//        }
//        while (true) {
//            //求data中可用的最小的数字，并记录对应文件的索引
//            int max = data[0];
//            int j = 0;
//            for (i = 0; i < file_count; ++i) {
//                if (hasNext[i] && max > data[i]) {
//                    max = data[i];
//                    j = i;
//                }
//            }
//            if (j == 0 && !hasNext[0]) break; //没有可取的数字，终止归并
//
//            if (fscanf(farray[j], "%d", & data[j]) ==EOF) //读取文件的下一个元素
//            hasNext[j] = false;
//            fprintf(fout, "%d ", max);
//
//        }
//
//        delete[] hasNext;
//        delete[] data;
//
//        for (i = 0; i < file_count; ++i) {
//            fclose(farray[i]);
//        }
//        delete[] farray;
//        fclose(fout);
//    }
}