class Solution {
    public int numWays(int n, int k) {
        if(n == 0)
            return 0;
        if(n == 1)
            return k;
        int[] diff = new int[n + 1];
        int[] same = new int[n + 1];
        diff[1] = k;
        same[1] = 0;
        for(int i = 2; i <= n; i++){
            diff[i] = (diff[i - 1] + same[i - 1]) * (k - 1);
            same[i] = diff[i - 1];
        }
        return diff[n] + same[n];
    }
}