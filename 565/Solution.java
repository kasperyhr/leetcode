class Solution {
    public int arrayNesting(int[] nums) {
        int ret = 0;
        for(int i = 0; i < nums.length; i++){
            ret = Math.max(dfs(nums, i), ret);
        }
        return ret;
    }
    
    private int dfs(int[] nums, int i){
        if(nums.length <= i)
            return 0;
        if(nums[i] == -1)
            return 0;
        int tmp = nums[i];
        nums[i] = -1;
        return dfs(nums, tmp) + 1;
    }
}