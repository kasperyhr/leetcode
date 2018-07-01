class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int major = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(cnt == 0){
                major = nums[i];
                cnt = 1;
            } else if(nums[i] == major){
                cnt += 1;
            } else {
                cnt -= 1;
            }
        }
        return major;
    }
}