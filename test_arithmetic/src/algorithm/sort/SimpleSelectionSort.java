package algorithm.sort;

/**
 * 简单选择排序 SimpleSelection Sort
 * <p>原理：每遍历未排序部分一次都选出一个最小值，并将最小值元素移动到数组前端
 *
 * @return
 */

public class SimpleSelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 8, 14, 9, 0, 7, 3};
        arr = new SimpleSelectionSort().simpleSelectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public int[] simpleSelectionSort(int[] array) {
        // 重复此过程：选取最小值，并将其交换至数组前端
        int minIndex = 0;
        for (int i = 0; i < array.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

}
