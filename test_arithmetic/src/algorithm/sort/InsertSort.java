package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 插入排序 Insert Sort
 * <p>原理：
 * 从第二个元素开始，因为左侧的数组为排序后的数组，
 * 只要将当前元素插入到左侧数组的适当位置，就能保持数组为有序
 * 然后处理第三个元素...直到最后一个元素
 *
 * @return
 */

public class InsertSort {
    public static void main(String[] args) {
        //int[] arr = new int[] { 1, 3, 8, 14, 9, 0, 7, 3 };
        int[] arr = new int[250];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100);
        }

        int[] _arr = arr;

        long t1 = System.currentTimeMillis();
        arr = new InsertSort().insertSort1(arr);
        long t2 = System.currentTimeMillis();

        long t3 = System.currentTimeMillis();
        _arr = new InsertSort().insertSort2(_arr);

        long t4 = System.currentTimeMillis();

        System.out.println(t2 - t1 + ":" + Arrays.toString(arr));
        System.out.println(t4 - t3 + ":" + Arrays.toString(_arr));
    }

    public int[] insertSort1(int[] array) {
        for (int i = 1; i < array.length; i++) {

            // 数组下标从当前元素往左移动，依次跟左边元素比较，如果当前比左边小则互换位置
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
            }

            System.out.println("第" + i + "次：" + Arrays.toString(array));
        }

        return array;
    }

    public int[] insertSort2(int[] array) {
        for (int i = 1; i < array.length; i++) {
            // 数组下标从当前元素往左移动，依次跟左边元素比较，如果当前比左边小则互换位置
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                } else {
                    break;
                }
            }

            System.out.println("第" + i + "次：" + Arrays.toString(array));
        }

        return array;
    }

}
