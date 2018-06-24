class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int[] dp = new int[prices.length];
        int[] min = new int[prices.length];
        dp[0] = 0;
        min[0] = prices[0];
        for(int i = 1; i < prices.length; i++){
            dp[i] = Math.max(dp[i - 1], prices[i] - min[i - 1]);
            min[i] = Math.min(min[i - 1], prices[i]);
        }
        return dp[dp.length - 1];
    }
}