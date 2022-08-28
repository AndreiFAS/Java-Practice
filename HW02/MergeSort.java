package HW02;


import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] test = new int[]{5, 4, -3, 2, 0};
        mergeSort(test, 0, test.length - 1);
        System.out.println(Arrays.toString(test));
    }

    static void mergeSort(int[] numbers, int start, int end) {
        if (start >= end) return;

        int mid = (start + end) / 2;
        mergeSort(numbers, start, mid);
        mergeSort(numbers, mid + 1, end);
        merge(numbers, start, mid, end);
    }

    static void merge(int[] numbers, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int left = start;
        int right = mid + 1;
        int k = 0;
        while (left <= mid && right <= end) {
            if (numbers[left] < numbers[right]) {
                temp[k++] = numbers[left++];
            } else {
                temp[k++] = numbers[right++];
            }
        }
        while (left <= mid) temp[k++] = numbers[left++];
        while (right <= end) temp[k++] = numbers[right++];

        for (int i = start; i <= end ; i++) {
            numbers[i] = temp[i - start];
        }
    }
}
