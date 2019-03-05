class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] ret = new int[r][c];
        int m = nums.length;
        int n = nums[0].length;
        if(m * n != r * c) return nums;
        for(int i = 0; i < r * c; i++){
            ret[i / c][i % c] = nums[i / n][i % n];
        }
        return ret;
    }
}