class Solution {
    int[][] memo;
    public boolean isMatch(String s, String p) {
        memo = new int[s.length() + 1][p.length() + 1];
        return dp(0,0,s,p) == 1;
    }
    private int dp(int i, int j, String s, String p){
        if(i > s.length())
            return -1;
        if(memo[i][j] != 0){
            return memo[i][j];
        }
        int ret = -1;
        if(j == p.length()){
            if(i == s.length()){
                ret = 1;
            }
        } else {
            if(i < s.length() && (s.charAt(i) == p.charAt(j)
                                               || p.charAt(j) == '?'))
                ret = dp(i + 1, j + 1, s, p);
            else if(i <= s.length() && p.charAt(j) == '*'){
                ret = Math.max(dp(i + 1, j, s, p), dp(i, j + 1, s, p));
            }
        }
        memo[i][j] = ret;
        return ret;
    }
}