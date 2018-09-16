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

                // 2、再找左边的第一个大于基准数的数
                while (i < j && arr[i] <= arr[left]) {
                    i++;
                }

                if (i != j) {
                    System.out.println("交换" + arr[i] + "和" + arr[j] + "：" );

                    // 3、找到后交换两个数在数组中的位置
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;

                    System.out.println(getArrayStr(arr, left, right));
                }
            }

            // 4、当i==j时，退出while循环，这一轮查找结束，交换基准数
            int x = arr[i];
            arr[i] = arr[left];
            arr[left] = x;

            System.out.println("交换基准数" + arr[left] + "和" + arr[i] + "：" + getArrayStr(arr, left, right) + "；");

            if (i-1 >= 0 && i+1 <= arr.length) {
                System.out.println("继续处理" + getArrayStr(arr, left, i - 1) + "和" + getArrayStr(arr, i + 1, right) + "\n");
                // 继续处理左边的，这里是一个递归的过程
                quickSort(arr, left, i - 1);
                // 继续处理右边的 ，这里是一个递归的过程
                quickSort(arr, i + 1, right);
            }
        }

        return arr;
    }

    private static String getArrayStr(int[] arr, int left, int right) {
        StringBuilder s = new StringBuilder();
        for (int i = left; i <= right; i++) {
            s.append(arr[i]).append(" ");
        }

        return s.toString();
    }

    public static void main(String[] args) {
        int[] arr = {5, 25, 9, 1, 16, 11, 19, 1, 6, 0};
        //int[] arr = {2, 6, 3, 7, 1, 5, 9, 8, 4, 0};
        //int[] arr = {2, 5, 6, 25, 3, 9, 1, 16, 7, 11, 0, 1, 19, 5, 1, 9, 8, 6, 4, 0};
        //int[] arr = {6, 1, 2, 7, 9};
        quickSort(arr, 0, arr.length - 1);
    }
}
