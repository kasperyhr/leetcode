class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int r = m;
        int c = n;
        for(int[] op: ops){
            r = Math.min(r, op[0]);
            c = Math.min(c, op[1]);
        }
        return r * c;
    }
}