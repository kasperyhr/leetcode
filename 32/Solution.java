class Solution {
    public int longestValidParentheses(String s) {
        int sLen = s.length();
        char[] chs = s.toCharArray();
        int[] dp = new int[sLen + 1];
        int ret = 0;
        for(int i = 1; i < sLen; i++){
            if(chs[i] == ')' && chs[i - 1] == '('){
                if(i >= 2)
                    dp[i] = dp[i - 2] + 2;
                else
                    dp[i] = 2;
            } else if(chs[i] == ')' && chs[i - 1] == ')' && i - dp[i - 1] - 1 >= 0 && chs[i - dp[i - 1] - 1] == '('){
                if(i - dp[i - 1] - 2 >= 0)
                    dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                else
                    dp[i] = dp[i - 1] + 2;
            }
            ret = Math.max(dp[i], ret);
        }
        return ret;
    }
}