package algorithm.sort;

/**
 * 希尔排序 Shell Sort
 * <p>原理：
 * 分别以数组大小的1/2,1/4,1/8....1的作为步伐d，
 * 将array[i],array[i + d],array[i + 2d]....array[i + nd]看作一个数组进行排序，
 * 与插入排序相比，因为可以更有效的消除逆序，因此交换次数是很少的，
 * 缺点是比较次数过多
 *
 * @return
 */

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 8, 14, 9, 0, 7, 3};
        arr = new ShellSort().shellSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public int[] shellSort(int[] array) {
        for (int d = array.length / 2; d > 0; d = d / 2) {
            for (int i = d; i < array.length; i++) {
                for (int j = i; j >= d; j = j - d) {
                    if (array[j] < array[j - d]) {
                        int temp = array[j];
                        array[j] = array[j - d];
                        array[j - d] = temp;
                    }
                }
            }
        }
        return array;
    }

}
