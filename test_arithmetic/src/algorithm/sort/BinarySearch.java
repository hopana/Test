package algorithm.sort;

public class BinarySearch {
    public int binarySearch(int[] dataset, int data) {
        int beginIndex = 0;
        int endIndex = dataset.length - 1;

        while (beginIndex <= endIndex) {
            int midIndex = (beginIndex + endIndex) >>> 1; // 相当于midIndex = (beginIndex + endIndex)/2  但是效率会高些
            if (data < dataset[midIndex]) {
                endIndex = midIndex - 1;
            } else if (data > dataset[midIndex]) {
                beginIndex = midIndex + 1;
            } else {
                return midIndex;
            }
        }

        return -1;
    }
}
