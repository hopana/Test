package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个有序数组，需要找出两个数组中的相同元素？
 * 两个下标分别指向数组的头部，比如，i 指向数组 a 的头部，j 指向数组 b 的头部，那么比较 a[i] 和 b[j]，
 * 如果 a[i] 较大，移动 j，如果 b[j] 较大，那么 移动 i，如果相等，那么 i 和 j 往后挪动，采用这种方式，只需要一次遍历即可
 *
 * @author hupan
 * @date 2018/09/25
 */
public class FindCommon {

    public static List<Integer> getCommons(int[] a , int[] b){
        //如果任何一个数组为空，那么就没有相同元素，边界判断
        if( a.length <= 0 || b.length <= 0 ){
            return null;
        }

        List commons = new ArrayList<>();
        int i = 0,j=0;
        for (;i<a.length;i++){
            if( j >= b.length){
                break;
            }
            //如果 a[i] 较大，那么就移动 j（前提：两个数组都是有序数组）
            while ( j < b.length-1 && a[i] > b[j]){
                j++;
            }

            if(a[i] == b[j]){
                commons.add(a[i]);
                if( j < b.length ){
                    j++;
                }
            }
        }
        return commons;
    }

    public static void main(String[] args) {
        int a[] = {1,1,2,3,3,5,6,8,9};
        int b[] = {0,1,3,3,5,6,10,12};

        List<Integer> result = getCommons(b,a);
        for (int i : result){
            System.out.print(i+",");
        }
    }
}