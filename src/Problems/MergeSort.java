package Problems;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {66, 55, 45, 3, 34, 34, 4, 665, 756, 756, 6345, 345, 64, 6547};
        mergeInSort(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    static int[] merge(int[] first, int[] second) {
        int[] afterMerge = new int[first.length + second.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                afterMerge[k] = first[i];
                i++;
            } else {
                afterMerge[k] = second[j];
                j++;
            }
            k++;
        }
        while (i < first.length) {
            afterMerge[k] = first[i];
            i++;
            k++;
        }
        while (j < second.length) {
            afterMerge[k] = second[j];
            j++;
            k++;
        }
        return afterMerge;
    }

//merge sort inplace without returning a new array

    static void mergeInSort(int[] arr,int s,int e) {
        if (e-s== 1) {
            return;
        }
        int mid = (s+e) / 2;
        mergeInSort(arr,s,mid);
        mergeInSort(arr,mid,e);

        mergeInplace(arr,s,mid,e);
    }

    static void mergeInplace(int[] arr,int s,int mid,int e) {
        int[] afterMerge = new int[e-s];
        int i = s;
        int j = mid;
        int k = 0;

        while (i < mid && j < e) {
            if (arr[i] < arr[j]) {
                afterMerge[k] = arr[i];
                i++;
            } else {
                afterMerge[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i < mid) {
            afterMerge[k] = arr[i];
            i++;
            k++;
        }
        while (j < e) {
            afterMerge[k] = arr[j];
            j++;
            k++;
        }
        for (int l = 0; l <afterMerge.length ; l++) {
            arr[s+l]=afterMerge[l];
        }

    }
}
