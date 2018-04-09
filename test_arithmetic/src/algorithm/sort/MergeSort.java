package algorithm.sort;

/**
 * 归并排序 Merge Sort
 * <p>原理： 分治。
 * 将数组分为左，右两部分， 首先将数组分为左右两部分，分别进行归并排序， 然后合并左右两部分的排序结果就构成了一个有序数组。
 *
 * @return
 */

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 8, 14, 9, 0, 7, 3};
        arr = new MergeSort().mergeRight(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 递归对数组进行归并排序
     *
     * @param array
     * @param startIndex
     * @param endIndex
     */
    private int[] mergeRight(int[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int mid = (startIndex + endIndex) / 2;
            // 对包括中点在内的左侧数组区间进行归并排序
            mergeRight(array, startIndex, mid);
            // 对中点之后的右侧数组区间进行归并排序
            mergeRight(array, mid + 1, endIndex);
            // 合并左和右两个独立的有序区间为一个有序区间
            merge(array, startIndex, mid, endIndex);
        }

        return array;
    }

    /**
     * 将array数组的两个有序区间
     * array[startIndex]...array[midIndex]
     * 和array[midIndex + 1]...array[endIndex]合并为一个有序区间
     * array[startIndex]...array[endIndex]
     *
     * @param array
     * @param startIndex
     * @param midIndex
     * @param endIndex
     */
    private void merge(int[] array, int startIndex, int midIndex, int endIndex) {
        int[] resultTemp = new int[endIndex - startIndex + 1];

        int pr = 0;
        int p1 = startIndex;
        int p2 = midIndex + 1;
        while (p1 <= midIndex || p2 <= endIndex) {
            if (p1 == midIndex + 1) {
                while (p2 <= endIndex) {
                    resultTemp[pr++] = array[p2++];
                }
            } else if (p2 == endIndex + 1) {
                while (p1 <= midIndex) {
                    resultTemp[pr++] = array[p1++];
                }
            } else if (array[p1] <= array[p2]) {
                resultTemp[pr++] = array[p1++];
            } else {
                resultTemp[pr++] = array[p2++];
            }
        }
        for (p1 = startIndex, p2 = 0; p1 <= endIndex; p1++, p2++) {
            array[p1] = resultTemp[p2];
        }
    }

}
