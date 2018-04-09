package algorithm.sort;

/**
 * 选择排序 Selection Sort
 * <p>原理:
 * 对待排序的记录序列进行n-1遍的处理，第1遍处理是将L[1..n]中最小者与L[1]交换位置
 * 第2遍处理是将L[2..n]中最小者与L[2]交换位置，...... 第i遍处理是将L[i..n]中最小者与L[i]交换位置。
 * 这样，经过i遍处理之后，前i个记录的位置就已经按从小到大的顺序排列好了。
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 8, 14, 9, 0, 7, 3, 11};
        arr = new SelectionSort().selectSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public int[] selectSort(int[] array) {
        int len = array.length;
        int temp;
        for (int i = 0; i < len; i++) {
            temp = array[i];
            int j;
            int sIndex = i;// 最小数的下标
            for (j = i + 1; j < len; j++) {
                if (array[j] < temp) {
                    temp = array[j];// 取出最小值
                    sIndex = j;// 取出最小值所在下标
                }
            }
            array[sIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

}
