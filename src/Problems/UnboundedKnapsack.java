package Problems;

public class UnboundedKnapsack {
    static void main() {
        int ans=unboundedKnapsack(4,20, new int[]{66, 100, 400, 1}, new int[]{6, 7, 8, 9});
        System.out.println(ans);
    }
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int []prev=new int[w+1];

        for(int i=0;i<=w;i++){
            prev[i]= ((int)(i/weight[0])) *profit[0];
        }
        
        for(int i=1;i<n;i++){
            for(int W=0;W<=w;W++){
                int nottake=0+prev[W];
                int take=0;
                if(weight[i]<=W){
                    take=profit[i]+prev[W-weight[i]];
                }
                prev[W]=Math.max(nottake,take);
            }
        }
        return prev[w];
        
    }
}