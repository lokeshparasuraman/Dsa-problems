package Problems;

import java.util.Arrays;

public class quickSort {
    public static void main(String[] args) {
        int[] arr = {5, 6, 4, 7, 1, 2, 9};
        quickSorting(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSorting(int[] arr, int low, int hi) {
        if (low >= hi) {
            return;
        }

        int s = low;
        int e = hi;
        int m = s + (e - s) / 2;
        int pivot = arr[m];

        while (s <= e) {
            while (arr[s] < pivot) {
                s++;
            }
            while (arr[e] > pivot) {
                e--;
            }
            if (s <= e) {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }
        //after reaching the correct pivot Problems.sorting before and after that pivot to get sorted array
        
        quickSorting(arr, low, e);
        quickSorting(arr, s, hi);
    }
}
