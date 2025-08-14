package Problems;

public class pivotsCount {

    public static void main(String[] args) {


        int []arr={2,2,6,7,0,1};
        System.out.println(count(arr));
    }
    static int count(int []arr){
        int c=pivotWithDuplicates(arr)+1;
        return c;
    }
    private static int pivot(int []arr)
    {
        int start=0;
        int end=arr.length-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2;

            if(mid <end && arr[mid] > arr[mid+1]) {
                return mid;
            }
            if(mid >start && arr[mid]< arr[mid-1]){
                return mid-1;
            }
            if(arr[mid]<=arr[start]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }

    private static int pivotWithDuplicates(int []arr)
    {
        int start=0;
        int end=arr.length-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(mid< end && arr[mid] > arr[mid+1]) {
                return mid;
            }
            if(mid >start && arr[mid]< arr[mid-1]){
                return mid-1;
            }
            if(arr[mid]==arr[end] && arr[mid]== arr[start])
            {
                if(arr[start]>arr[start+1]) {
                    return start;
                }
                start++;
                if(arr[end]<arr[end-1]){
                    return end-1;
            }
                end--;
            }
            else if(arr[start]< arr[mid] || (arr[start]==arr[mid]&&arr[end]<arr[mid] )){
                start=mid+1;

            }else{
                end=mid-1;
            }
        }
        return -1;
    }
}
