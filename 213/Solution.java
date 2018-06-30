class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0], nums[1]);
        if(nums.length == 3)
            return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        dp[1][0] = nums[1];
        dp[1][1] = nums[0];
        dp[2][0] = Math.max(dp[1][0], nums[2]);
        dp[2][1] = nums[0] + nums[2];
        for(int i = 3; i < nums.length - 1; i++){
            dp[i][0] = Math.max(Math.max(dp[i - 2][0], dp[i - 3][0]) + nums[i], dp[i - 1][0]);
            dp[i][1] = Math.max(Math.max(dp[i - 2][1], dp[i - 3][1]) + nums[i], dp[i - 1][1]);
        }
        dp[nums.length - 1][0] = Math.max(Math.max(dp[nums.length - 3][0], dp[nums.length - 4][0]) + nums[nums.length - 1], dp[nums.length - 2][0]);
        dp[nums.length - 1][1] = Math.max(dp[nums.length - 3][1], dp[nums.length - 2][1]);
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }
}