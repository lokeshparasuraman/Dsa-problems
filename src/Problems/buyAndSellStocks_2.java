package Problems;

class buyAndSellStocks_2 {
    static void main() {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
    public static int maxProfit(int[] prices) {

        int n = prices.length;

        int[][] dp = new int[n+1][2];

        for(int i=n-1;i>=0;i--){
            
            for(int buy=0;buy<=1;buy++){

                long profit=0;
                if(buy==1){
                    profit=Math.max(-prices[i]+dp[i+1][0],dp[i+1][1]);
                }
                else{
                    profit=Math.max(prices[i]+dp[i+1][1],dp[i+1][0]);
                }
                dp[i][buy]=(int)profit;
            }
        }
        return dp[0][1];

        
    }
}