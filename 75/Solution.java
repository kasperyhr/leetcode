class Solution {
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        for(int i = 0; i <= end; i++){
            if(nums[i] == 0)
                swap(nums, start++, i);
            else if(nums[i] == 2)
                swap(nums, end--, i--);
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}