class Solution {
    Integer[][] memo;
    public int tallestBillboard(int[] rods) {
        memo = new Integer[rods.length][10001];
        return dp(rods, 0, 5000);
    }
    private int dp(int[] rods, int idx, int sum){
        if(idx == rods.length){
            if(sum == 5000)
                return 0;
            else
                return Integer.MIN_VALUE;
        }
        if(memo[idx][sum] != null){
            return memo[idx][sum];
        }
        int ret = dp(rods, idx + 1, sum);
        ret = Math.max(ret, dp(rods, idx + 1, sum + rods[idx]));
        ret = Math.max(ret, rods[idx] + dp(rods, idx + 1, sum - rods[idx]));
        memo[idx][sum] = ret;
        return memo[idx][sum];
    }
}