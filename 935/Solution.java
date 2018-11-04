class Solution {
    public int knightDialer(int N) {
        if(N == 1)
            return 10;
        long[] dp_0 = new long[N + 1];
        long[] dp_1 = new long[N + 1];
        long[] dp_2 = new long[N + 1];
        long[] dp_3 = new long[N + 1];
        long[] dp_4 = new long[N + 1];
        long[] dp_5 = new long[N + 1];
        long[] dp_6 = new long[N + 1];
        long[] dp_7 = new long[N + 1];
        long[] dp_8 = new long[N + 1];
        long[] dp_9 = new long[N + 1];
        
        int MOD = 1000000007;
        dp_0[1] = 1;
        dp_1[1] = 1;
        dp_2[1] = 1;
        dp_3[1] = 1;
        dp_4[1] = 1;
        dp_6[1] = 1;
        dp_7[1] = 1;
        dp_8[1] = 1;
        dp_9[1] = 1;
        
        for(int i = 2; i <= N; i++){
            dp_0[i] = (dp_4[i - 1] + dp_6[i - 1]) % MOD;
            dp_1[i] = (dp_6[i - 1] + dp_8[i - 1]) % MOD;
            dp_2[i] = (dp_7[i - 1] + dp_9[i - 1]) % MOD;
            dp_3[i] = (dp_4[i - 1] + dp_8[i - 1]) % MOD;
            dp_4[i] = (dp_3[i - 1] + dp_9[i - 1] + dp_0[i - 1]) % MOD;
            dp_6[i] = (dp_1[i - 1] + dp_7[i - 1] + dp_0[i - 1]) % MOD;
            dp_7[i] = (dp_2[i - 1] + dp_6[i - 1]) % MOD;
            dp_8[i] = (dp_1[i - 1] + dp_3[i - 1]) % MOD;
            dp_9[i] = (dp_2[i - 1] + dp_4[i - 1]) % MOD;
        }
        return (int)((dp_0[N] + dp_1[N] + dp_2[N] + dp_3[N] + dp_4[N] + dp_6[N] + dp_7[N] + dp_8[N] + dp_9[N]) % MOD);
    }
}