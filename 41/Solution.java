class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0 && nums[i] <= nums.length)
                test[nums[i]] = true;
        }
        for(int i = 1; i < test.length; i++){
            if(!test[i])
                return i;
        }
        return 0;
    }
}