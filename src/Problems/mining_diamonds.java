package Problems;

public class mining_diamonds {
    static void main() {
        System.out.println(maxCoins(new int[]{1, 2, 3}));
    }

    public static int maxCoins(int a[]) {

        int n=a.length;

        int []ar=new int[n+2];

        ar[0]=1;
        ar[n+1]=1;
        
        System.arraycopy(a,0,ar,1,n);
        int[][]dp=new int[n+2][n+2];

        for(int i=n;i>=1;i--){

            for(int j=1;j<=n;j++){
                
                if(i>j)continue;

                int max=(int)(-1e9);

                for(int ind=i;ind<=j;ind++){

                    int cost=ar[i-1]*ar[ind]*ar[j+1]+
                    dp[i][ind-1]+
                    dp[ind+1][j];

                    max=Math.max(max,cost);
                }
                dp[i][j]=max;
            }
        }
        return dp[1][n];
    }

}