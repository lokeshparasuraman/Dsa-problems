package Problems;

public class BinarySearch {
    public static void main(String[] args) {
        int[] numb = {2, 5, 6, 8, 9, 10};
        int ans = binarySearchRecursion(numb, 6, 0, numb.length);
        System.out.println(ans);
    }
    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    static int binarySearchRecursion(int[] arr, int target, int s, int e) {
        if (s > e) {
            return -1;
        }

        int m = s + (e - s) / 2;
        if (arr[m] == target) {
            return m;
        }
        if (target < arr[m]) {
            return binarySearchRecursion(arr, target, s, m - 1);
        }

        return binarySearchRecursion(arr, target, m + 1, e);
    }
}







