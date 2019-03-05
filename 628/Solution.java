class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length - 1;
        int ret = nums[len] * nums[len - 1] * nums[len - 2];
        ret = Math.max(ret, nums[len] * nums[len - 1] * nums[0]);
        ret = Math.max(ret, nums[len] * nums[1] * nums[0]);
        ret = Math.max(ret, nums[2] * nums[1] * nums[0]);
        return ret;
    }
}