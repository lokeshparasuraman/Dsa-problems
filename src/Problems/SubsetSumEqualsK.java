package Problems;

public class SubsetSumEqualsK {
    static void main() {
        int []arr={2,3,1,1};
        System.out.println(solve2(3,arr,4));
    }
    public static  boolean solve(int n,int[]arr,int k){
        boolean []dp=new boolean[k+1];

        dp[0]=true;

        if(arr[0]<=k){
            dp[arr[0]]=true;
        }
        for(int i=1;i<n;i++){

            for (int target = k; target>=arr[i] ; target--) {
                dp[target]=dp[target]||dp[target-arr[i]];
            }
        }

        return dp[k];
    }
    public static boolean solve2(int n,int[]a,int k){
        boolean[]prev=new boolean[k+1];

        prev[0]=true;


        prev[a[0]]=true;

        for(int i=1;i<n;i++){
            boolean[]curr=new boolean[k+1];
            curr[0]=true;
            for(int target=1;target<=k;target++){
                boolean notTake=prev[target];
                boolean take=false;
                if(a[i]<=target){
                    take=prev[target-a[i]];
                }
                curr[target]=take||notTake;
            }
            prev=curr;
        }
        return prev[k];
    }
}
