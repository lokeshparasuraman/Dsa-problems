package Problems;

public class Kth_largest_inArray {
    static void main() {
        int[] nums = {4, 6, 5, 1, 2};
        int[]n2={10,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5};
        System.out.println(kthLargest(n2,2));
//        System.out.println(kthLargest(nums, 2));
    }

    private static int kthLargest(int[] arr, int k) {
        if(arr.length<=1){
            return -1;
        }
        int low = arr[0], high = arr[0];
        for (int num : arr) {
            if (num < low) {
                low = num;
            }
            if (num > high) {
                high = num;
            }
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count=0;
            for (int n : arr) {
                if (n > mid)
                    count++;
            }
                if (count >= k)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        return low;
}
}
