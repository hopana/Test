package algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序 Bubble Sort
 * <p>
 * 原理: 比较n轮，每一轮都把最大元素移动到数组后端。
 *
 * @return
 */

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 8, 14, 9, 0, 7, 3, 11, 2, 7, 18, 5, 9, 10, 1, 4};
        arr = new BubbleSort().bubbleSort2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // 依次比较相邻元素，每一轮都把最大元素移动到数组后端
    public int[] bubbleSort1(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - (i + 1); j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

            System.out.println("第" + (i + 1) + "次：" + Arrays.toString(array));
        }
        return array;
    }

    // 改进的冒泡排序1，思想：内层循环中，如果没有交换，说明数组已经排好序，无需再扫描
    public int[] bubbleSort2(int[] array) {
        boolean flag = false;

        for (int i = 0; i < array.length; i++) {
            flag = true;
            for (int j = 0; j < array.length - (i + 1); j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    flag = false;
                }
            }

            if (flag)
                break;

            System.out.println("第" + (i + 1) + "次：" + Arrays.toString(array));
        }
        return array;
    }

}
