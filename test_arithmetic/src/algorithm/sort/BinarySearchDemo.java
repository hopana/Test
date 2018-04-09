package algorithm.sort;

/**
 * 二分查找算法练习
 *
 * @author hupan
 * @date 2017-08-11 12:51:2
 */
public class BinarySearchDemo {
    public static int binarySearch(int[] arr, int dest) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            if (dest == arr[mid]) {
                return mid;
            } else if (dest < arr[mid]) {
                high = mid - 1;
            } else if (dest > arr[mid]) {
                low = mid + 1;
            } else {
                return -1;
            }
        }

        return -1;
    }

    /**
     * 查找第一次出现的位置
     *
     * @param arr
     * @param dest
     * @return
     */
    public static int binarySearchFirst(int[] arr, int dest) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = ((low + high) >> 1);
            if (dest > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        if (arr[low] == dest)
            return low;

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 5, 7, 9, 13, 15, 15, 20, 28};
        System.out.println(binarySearch(arr, 15));
        System.out.println(binarySearchFirst(arr, 15));
    }
}
