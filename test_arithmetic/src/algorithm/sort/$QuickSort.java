package algorithm.sort;

public class $QuickSort {
	
	public static void main(String[] args) {
		int[] arr = {2, 6, 3, 7, 1, 5, 9, 8, 4, 0};
		arr = quickSort(arr, 0, arr.length - 1);
		
		for (int a : arr) {
			System.out.print(a + " ");
		}
	}

	public static int[] quickSort(int[] arr, int left, int right) {

		if (left < right) {
			int i = left, j = right;
			while (i != j) {
				
				while (i < j && arr[i] < arr[left]) {
					i++;
				}
				
				while (i < j && arr[j] > arr[left]) {
					j--;
				}
				
				int x = arr[i];
				arr[i] = arr[j];
				arr[j] = x;
			}
			
			int x = arr[i];
			arr[i] = arr[left];
			arr[left] = x;
			
			quickSort(arr, left, i-1);
			quickSort(arr, i+1, right);
		}

		return arr;
	}

}
