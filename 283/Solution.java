class Solution {
    public void moveZeroes(int[] nums) {
        int idx = 0;
        int l = 0;
        while(idx < nums.length){
            if(nums[idx] != 0){
                swap(nums, idx, l++);
            }
            idx++;
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}