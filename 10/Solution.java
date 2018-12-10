class Solution {
    int[][] memo;
    public boolean isMatch(String s, String p) {
        memo = new int[s.length() + 1][p.length() + 1];
        return dp(0,0,s,p) == 1;
    }
    private int dp(int i, int j, String s, String p){
        if(memo[i][j] != 0){
            return memo[i][j];
        }
        int ret = -1;
        if(j == p.length()){
            if(i == s.length()){
                ret = 1;
            }
        } else {
            boolean match = i < s.length() && (s.charAt(i) == p.charAt(j)
                                               || p.charAt(j) == '.');
            
            if(j + 1 < p.length() && p.charAt(j + 1) == '*'){
                ret = Math.max(ret, dp(i, j + 2, s, p));
                if(match){
                    ret = Math.max(ret, dp(i + 1, j, s, p));
                }
            } else {
                if(match){
                    ret = Math.max(ret, dp(i + 1, j + 1, s, p));
                }
            }
        }
        memo[i][j] = ret;
        return ret;
    }
}