class Solution {
    public int pivotIndex(int[] nums) {
        if(nums.length == 0)
            return -1;
        if(nums.length == 1)
            return 0;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            sum[i] = sum[i - 1] + nums[i];
        }
        int total_sum = sum[nums.length - 1];
        if(total_sum - sum[0] == 0)
            return 0;
        for(int i = 1; i < nums.length; i++){
            int left = sum[i - 1];
            int right = total_sum - sum[i];
            if(left == right)
                return i;
        }
        return -1;
    }
}