class Solution {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        int p = 0;
        for(int i = 1; i < nums.length; i++)
            if(nums[i - 1] > nums[i]){
                cnt++;
                p = i;
            }
        if(cnt > 1)
            return false;
        return (cnt == 0 || p == 1 || p == nums.length - 1 || nums[p - 1] <= nums[p + 1] || nums[p - 2] <= nums[p]);
    }
}