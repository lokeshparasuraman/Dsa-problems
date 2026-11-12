package Problems;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {66, 55, 45, 3, 34, 34, 4, 665, 756, 756, 6345, 345, 64, 6547};
        mergeInSort(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));

    }
//merge sort inplace without returning a new array
    static void mergeInSort(int[] arr,int s,int e) {
        if (s>=e) {
            return;
        }
        int mid = (s+e) / 2;
        mergeInSort(arr,s,mid);
        mergeInSort(arr,mid+1,e);

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
