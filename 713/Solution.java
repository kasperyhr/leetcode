class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start = 0;
        int prod = 1;
        int ret = 0;
        for(int end = 1; end <= nums.length; end++){
            prod *= nums[end - 1];
            while(prod >= k && start < end){
                prod /= nums[start];
                start++;
            }
            ret += end - start;
        }
        return ret;
    }
}