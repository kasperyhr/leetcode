class Solution {
    public int minCostII(int[][] costs) {
        int N = costs.length;
        if(N == 0)
            return 0;
        int K = costs[0].length;
        if(K == 1){
            int ret = 0;
            for(int i = 0; i < N; i++){
                ret += costs[i][0];
            }
            return ret;
        }
        int[][] dp = new int[N][K];
        int ps1 = Integer.MAX_VALUE;
        int pi1 = 0;
        int ps2 = Integer.MAX_VALUE;
        int pi2 = 0;
        for(int i = 0; i < K; i++){
            dp[0][i] = costs[0][i];
            if(ps1 >= dp[0][i]){
                ps2 = ps1;
                pi2 = pi1;
                ps1 = dp[0][i];
                pi1 = i;
            } else if(ps2 >= dp[0][i]){
                ps2 = dp[0][i];
                pi2 = i;
            }
        }
        int s1 = Integer.MAX_VALUE;
        int i1 = 0;
        int s2 = Integer.MAX_VALUE;
        int i2 = 0;
        for(int i = 1; i < N; i++){
            s1 = ps1;
            i1 = pi1;
            s2 = ps2;
            i2 = pi2;
            ps1 = Integer.MAX_VALUE;
            pi1 = 0;
            ps2 = Integer.MAX_VALUE;
            pi2 = 0;
            for(int j = 0; j < K; j++){
                if(j == i1)
                    dp[i][j] = dp[i - 1][i2] + costs[i][j];
                else
                    dp[i][j] = dp[i - 1][i1] + costs[i][j];
                if(ps1 >= dp[i][j]){
                    ps2 = ps1;
                    pi2 = pi1;
                    ps1 = dp[i][j];
                    pi1 = j;
                } else if(ps2 >= dp[i][j]){
                    ps2 = dp[i][j];
                    pi2 = j;
                }
            }
        }
        int ret = Integer.MAX_VALUE;
        for(int i = 0; i < K; i++){
            ret = Math.min(ret, dp[N - 1][i]);
        }
        return ret;
    }
}