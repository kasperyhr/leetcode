class Solution {
    public boolean canJump(int[] nums) {
        boolean ret = true;
        int len = 1;
        for(int i = nums.length - 2; i >= 0; i--)
            if(nums[i] == 0){
                ret = false;
                len += 1;
            } else {
                 if(!ret){
                     if(nums[i] >= len){
                         len = 1;
                         ret = true;
                     } else {
                         len += 1;
                     }
                 }
            }
        return ret;
    }
}