package algorithm;

/**
 * 把一个0-1串（只包含0和1的串）进行排序，你可以交换任意两个位置，问最少交换的次数？（国内某公司最新在线笔试题）
 */
public class Swap0And1 {
    public static void main(String[] args) {
        String s = "001100010101110111010010";

        System.out.println(swap(s));
    }

    public static int swap(String s) {
        char[] a = s.toCharArray();

        int count = 0;
        for (int i = 0, j = a.length - 1; i < j; ++i, --j) {
            for (; (i < j) && (a[i] == '0'); ++i) ;
            for (; (j > i) && (a[j] == '1'); --j) ;

            if (i < j) {
                ++count;

                char t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }

        // 打印交换后的字符串
        for (char c : a) {
            System.out.print(c + " ");
        }

        System.out.println();

        return count;
    }
}
