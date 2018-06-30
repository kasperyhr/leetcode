class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0], nums[1]);
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        dp[2] = Math.max(dp[0] + nums[2], dp[1]);
        for(int i = 3; i < nums.length; i++)
            dp[i] = Math.max(Math.max(dp[i - 2], dp[i - 3]) + nums[i], dp[i - 1]);
        return dp[dp.length - 1];
    }
}