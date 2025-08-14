package Problems;

import java.util.Arrays;

public class sorting {
    public static void main(String[] args) {
        int[] arr = {5,3,4,1,2};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));

    }
    static void cyclicSort(int[]arr){
        int i=0;
        while (i<arr.length){
            int correct=arr[i]-1;
            if(arr[i]!=arr[correct]){
                swap(arr,i,correct);
            }
            else{
                i++;
            }

        }

    }
    static void insertionSort(int[]arr){

        for(int i=0;i<arr.length-1;i++)
        {
            for(int j=i+1;j>0;j--)
            {
                if(arr[j]<arr[j-1])
                    swap(arr, j, j-1);
                else
                    break;
            }
        }
    }
    //selection sort
    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - i - 1;
            int max = getMaxIndex(arr, 0, last);
            swap(arr, max, last);
        }
    }

    static int getMaxIndex(int[] arr, int start, int end) {
        int max = start;
        for (int i = start; i <= end; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }
        return max;
    }
    //end selection sort

    static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    static void bubbleSort(int[] arr) {
        boolean isSwapped;
        for (int i = 0; i < arr.length; i++) {
            isSwapped = false;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                    isSwapped = true;
                }

            }
            if (!isSwapped)
                break;
        }
    }
}
