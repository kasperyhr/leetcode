class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        return nums.length * (nums.length + 1) / 2 - sum;
    }
}