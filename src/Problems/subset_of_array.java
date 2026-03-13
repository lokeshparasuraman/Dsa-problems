package Problems;

public class subset_of_array {
    static void main() {
        int[]a={1,2,3,4};
        int[]b={2,4};
        System.out.println(subset(a,b));
    }
    private static boolean subset(int []arr1,int []arr2){
        int i=0,j=0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]==arr2[j]){
                i++;
                j++;
            }
            else if(arr1[i]<arr2[j]){
                i++;
            }
            else {
                return false;
            }

        }
        return j==arr2.length;
    }
}
