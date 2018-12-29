class Solution {
    public int[] findErrorNums(int[] nums) {
        boolean[] f = new boolean[nums.length];
        int dup = 0;
        int mis = 0;
        for(int i = 0; i < nums.length; i++){
            if(f[nums[i] - 1])
                dup = nums[i];
            else
                f[nums[i] - 1] = true;
        }
        for(int i = 1; i <= nums.length; i++){
            if(!f[i - 1]){
                mis = i;
                break;
            }
        }
        return new int[]{dup, mis};
    }
}