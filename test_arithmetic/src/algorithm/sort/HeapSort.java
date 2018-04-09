package algorithm.sort;

/**
 * 堆排序 Heap Sort
 * <p>原理:
 * 利用了堆的易调整的特点来进行的一种选择排序。
 * 以大顶堆为例，什么是大顶堆？
 * 大顶堆的逻辑结构是一颗完全二叉树，[把满二叉树最后一层右侧的一些叶子摘掉]
 * 假设其高度为h，则元素个数介于
 * 1 + 2 + ... + exp(2, h - 2) ~ 1 + 2 + ... + exp(2, h -1)之间
 * 符合如下定义为大顶堆：(此定义基于大顶堆的顺序存储结构)
 * for (int i = array.length - 1; i > 0; i --) {
 * 任意 array[i] <= array[(i - 1)/2];
 * }
 * (还有一种是小顶堆，不同的只是比较时候的大于号方向不同)。
 * 容易想到，当堆顶元素(MaxValue)被替换后，
 * 至多只要在双亲和子节点间进行h（大顶堆的高度） - 1次交换，
 * (参照交换算法可以发现比较次数一般来说是交换次数的2~3倍，也不算多)
 * 就可以形成新的大顶堆。由此大大提高了排序效率。
 *
 * @return
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 8, 14, 9, 0, 7, 3};
        arr = new HeapSort().heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public int[] heapSort(int[] array) {
        // 初始化无序数组为大顶堆
        for (int i = array.length - 2; i >= 0; i--) {
            adjustHeap(array, i, array.length - 1);
        }
        // 将最大值元素交换至数组末端，并调整前端为大顶堆，循环直至前端只剩下一个元素
        for (int i = array.length - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            adjustHeap(array, 0, i - 1);
        }
        return array;
    }

    /**
     * 将除顶(不确定是否满足大顶堆条件)外，左子树和右子树都为一个堆的数组调整为大顶堆
     *
     * @param array 待调整数组
     * @param from  顶的指针
     * @param to    调整的末端(就是调整array[from]...array[to]这一段为一个大顶堆)
     */
    private void adjustHeap(int[] array, int from, int to) {
        int i = 0;
        // 比较节省比较次数的方法，只要比较到比其左右子树的根结点的值都大，就可以return了
        while (from + 2 * i + 2 <= to) {
            if (array[from + i] < array[from + 2 * i + 1]
                    || array[from + i] < array[from + 2 * i + 2]) {
                if (array[from + 2 * i + 1] > array[from + 2 * i + 2]) {
                    int temp = array[from + i];
                    array[from + i] = array[from + 2 * i + 1];
                    array[from + 2 * i + 1] = temp;
                    i += i + 1;
                } else {
                    int temp = array[from + i];
                    array[from + i] = array[from + 2 * i + 2];
                    array[from + 2 * i + 2] = temp;
                    i += i + 2;
                }
            } else {
                return;
            }
        }
        if (from + 2 * i + 1 == to && array[from + i] < array[from + 2 * i + 1]) {
            // 有时会出现仅存在左子树的情况(左子树为调整数组的最后一个元素)
            int temp = array[from + i];
            array[from + i] = array[from + 2 * i + 1];
            array[from + 2 * i + 1] = temp;
        }
    }

}
