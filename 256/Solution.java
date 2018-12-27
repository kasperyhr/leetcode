class Solution {
    public int minCost(int[][] costs) {
        int N = costs.length;
        if(N == 0)
            return 0;
        int[][] dp = new int[N][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for(int i = 1; i < N; i++){
            for(int j = 0; j < 3; j++){
                dp[i][j] = Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]) + costs[i][j];
            }
        }
        int ret = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++){
            ret = Math.min(ret, dp[N - 1][i]);
        }
        return ret;
    }
}