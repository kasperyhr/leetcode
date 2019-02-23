class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int max = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];
        for(int i = 1; i < nums.length; i++){
            int tmp = currMax;
            currMax = Math.max(Math.max(nums[i], currMax * nums[i]), currMin * nums[i]);
            currMin = Math.min(Math.min(nums[i], tmp * nums[i]), currMin * nums[i]);
            max = Math.max(currMax, max);
        }
        return max;
    }
}