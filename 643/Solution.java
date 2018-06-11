class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for(int i = 0; i < k; i++)
            sum += nums[i];
        int currsum = sum;
        for(int i = k; i < nums.length; i++){
            currsum += nums[i] - nums[i - k];
            if(currsum > sum)
                sum = currsum;
        }
        return sum * 1.0 / k;
    }
}