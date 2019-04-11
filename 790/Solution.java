class Solution {
    public int numTilings(int N) {
        if(N == 0) return 1;
        if(N == 1) return 1;
        int mod = 1000000007;
        int[][] dp = new int[N + 1][2];
        
        // Base case:
        dp[0][0] = 1;
        dp[1][0] = 1;
        dp[1][1] = 1;
        
        for(int i = 2; i <= N; i++){
            dp[i][0] = ((dp[i - 1][0] + dp[i - 2][0]) % mod + (dp[i - 2][1] * 2) % mod) % mod;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
        }
        
        return dp[N][0];
    }
}