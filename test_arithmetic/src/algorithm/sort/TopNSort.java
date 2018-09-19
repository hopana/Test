package algorithm.sort;

//*********************************************************
//面试题：N个数找出最大的前K个（N超级大）
//
//思路：用前K个数建个小堆，然后向后遍历其余数，凡是遇到比堆根节点大的，
//      就替换根节点，然后向下调整，使之始终保持小堆，然后继续遍历，
//      直至访问完数据。这样就将前K个大的数据全放在了堆中。
//
//时间复杂度：建堆+遍历（KlgK+(N-K)lgN） ->NlgK
//*********************************************************

public class TopNSort {

    private static int N = 10000;
    private static int K = 10;

    //向下调整
    private static void adjustDown(int[] a) {
        int father = 0;
        int child = (a[father * 2 + 1] < a[father * 2 + 2] ? (father * 2 + 1) : (father * 2 + 2));
        while (a[father] > a[child] && child < K) {
            swap(a[father], a[child]);
            father = child;
            if (father * 2 + 1 == K - 1) {
                child = father * 2 + 1;
            }

            if (father * 2 + 1 < K - 1) {
                child = (a[father * 2 + 1] < a[father * 2 + 2] ? (father * 2 + 1) : (father * 2 + 2));
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[N];
        for (int i = 0; i < N; ++i) {
            a[i] = rand() % 100;  //赋值为小于100的随机值
        }

        a[54] = 111;
        a[542] = 122;
        a[2] = 3124;
        a[393] = 999;
        a[333] = 888;
        a[1001] = 789;
        a[3214] = 1131;
        a[3245] = 1115;
        a[3924] = 911;
        a[112] = 112;

        make_heap(a, a + K, greater < int>());  //建小堆

        for (int i = 0; i < K; ++i) {
            System.out.println(a[i] );
        }


        for (int i = K; i < N; ++i) {
            if (a[i] >= a[0]) {
                a[0] = a[i];
                adjustDown(a);
            }
        } System.out.println("make_heap:" );
        for (int i = 0; i < K; ++i) {
            System.out.println(a[i] );
        }
    }

    private static void swap(int a, int b) {

    }

    //////////////////////////////////////////////////////////
    //堆排序（选择排序的一种）
    //
    //思路：1，升序：先建一个大堆(0,n-1)，然后将堆顶节点（值最大的节点）
    //               与堆最后一个节点交换，然后就形成了两部分：有序区
    //              （n-1）和 无序区(0,n-2),然后将无序区调整为堆，循环
    //               以上步骤，直至最后一个节点
    //      2，降序：建一个小堆，其余和升序本质一样。
    //
    //时间复杂度：N*logN
    ///////////////////////////////////////////////////////////

    //升序
//    private static void HeadSort(int[] a, size_t n) {
//        for (int i = n; i > 0; i--) {
//            make_heap(a, a + i);    //建大堆
//            swap(a[0], a[i - 1]);   //交换堆顶节点与堆尾节点
//        }
//    }
//
//
//    public static void main(String[] args) {
//        int a[ 10] ={ 0 } ;
//        for (int i = 0; i < 10; ++i) {
//            a[i] = 10 - i;
//        }
//
//        HeadSort(a, 10);
//
//        for (int i = 0; i < 10; ++i) {
//            System.out.println(a[i] );
//        }
//    }
//
//    private void swap(int a, int b) {
//
//    }
}