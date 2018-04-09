package algorithm.sort;

import java.util.Random;

public class SelectSort {

    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i; j <= array.length - 1; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }

            if (min != i) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 25, 9, 1, 16, 11, 19, 1, 6, 0};
        selectSort(a);
    }
}
