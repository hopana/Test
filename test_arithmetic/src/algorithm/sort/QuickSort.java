package algorithm.sort;

public class QuickSort {

    private static int[] quickSort(int[] arr, int left, int right) {

        if (left < right) {
            int i = left;
            int j = right;

            while (i != j) {
                // 1、先从右边开始找第一个小于基准数的数（顺序很重要）
                while (i < j && arr[j] >= arr[left]) {
                    j--;
                }

                // 2、再找左边的第一个小于基准数的数
                while (i < j && arr[i] <= arr[left]) {
                    i++;
                }

                // 3、找到后交换两个数在数组中的位置
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }

            // 4、当i==j时，退出while循环，这一轮查找结束，交换基准数
            int x = arr[i];
            arr[i] = arr[left];
            arr[left] = x;

            quickSort(arr, left, i - 1);// 继续处理左边的，这里是一个递归的过程
            quickSort(arr, i + 1, right);// 继续处理右边的 ，这里是一个递归的过程
        }

        return arr;
    }

    public static void main(String[] args) {
        //int[] arr = {5, 25, 9, 1, 16, 11, 19, 1, 6, 0};
    	//int[] arr = {2, 6, 3, 7, 1, 5, 9, 8, 4, 0};
    	//int[] arr = {2, 5, 6, 25, 3, 9, 1, 16, 7, 11, 0, 1, 19, 5, 1, 9, 8, 6, 4, 0};
    	int[] arr = {4, 2, 6, 3, 7, 10};
        arr = quickSort(arr, 0, arr.length - 1);

        for (int k = 0; k < arr.length; k++) {
            //System.out.print(arr[k] + " ");
        }
    }
}
