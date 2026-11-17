package Problems;

class leetcode_309 {
    static void main() {
        System.out.println(maxProfit(new int[]{1,2,3,0,2}));
    }
    //Best  time to buy and sell with cooldown
    public static int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] cur = new int[n + 2][2];

        for (int i = n - 1; i >= 0; i--) {
            //buy
            cur[i][1] = Math.max(
                    -prices[i] + cur[i + 1][0],
                    cur[i + 1][1]);
            //sell
            cur[i][0] = Math.max(
                    prices[i] + cur[i + 2][1],
                    cur[i + 1][0]);
        }
        return cur[0][1];
    }
}