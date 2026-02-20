package Problems;

public class find_missing_number_in_array {


    static void main() {
        int []arr={0,1,2,3,5};
        System.out.println(search(arr));
    }

    private static int search(int[] arr) {
        int n=arr.length;
        if(n<=0){
            return -1;
        }
        int total=n*(n+1)/2;
        for(int num:arr){
            total-=num;
        }
        return total;
    }
}
