class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length < 2) return 0;
        Arrays.sort(nums);
        int ret = 0;
        for(int i = 1; i < nums.length; i++){
            ret = Math.max(ret, nums[i] - nums[i - 1]);
        }
        return ret;
    }
}