package Problems;

public class RBS {
    public static void main(String[] args) {
            int[]a={};
        System.out.println(search(a,54,0,a.length-1));
    }

    //rotated binarySearch using recursion just for learning purpose
    static int search(int[]arr,int target,int s,int e){
        if(s>e){
            return -1;
        }
        int m=s+(e-s)/2;
        if(target==arr[m]){
            return m;
        }
        if(arr[s]<=arr[m]){
            if(target<=arr[m] && target>=arr[s]){
                return search(arr,target,s,m-1);
            }
            else{
                return search(arr,target,m+1,e);
            }
        }
        if(target >=arr[m] && target <=arr[e]){
            return search(arr,target,m+1,e);
        }
        return search(arr,target,s,m-1);
    }
}
