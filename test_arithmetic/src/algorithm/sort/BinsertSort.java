package algorithm.sort;

/**
 * 折半搜索插入排序 BinarySearchThenInsert Sort 原理与插入排序类似，不同点在于寻找插入位置的时候，采取的是折半查找方法
 *
 * @return
 */
public class BinsertSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 8, 14, 9, 0, 7, 3};
        arr = new BinsertSort().binsertSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public int[] binsertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[0]) {
                int temp = array[i];
                for (int j = i - 1; j >= 0; j--) {
                    array[j + 1] = array[j];
                }
                array[0] = temp;
            } else if (array[i] < array[i - 1]) {
                int larrange = 0;
                int rarrange = i - 1;
                while (rarrange - larrange > 1) {
                    int p = (rarrange + larrange + 1) / 2;
                    if (array[i] < array[p]) {
                        rarrange = p;
                    } else {
                        larrange = p;
                    }
                }
                int temp = array[i];
                for (int j = i - 1; j >= larrange + 1; j--) {
                    array[j + 1] = array[j];
                }
                array[larrange + 1] = temp;
            }
        }
        return array;
    }

}
