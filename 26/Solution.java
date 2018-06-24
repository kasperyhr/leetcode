class Solution {
    public int removeDuplicates(int[] nums) {
        int ptr = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] != nums[i]) {
                nums[ptr] = nums[i];
                ptr += 1;
            }
        }
        return ptr;
    }
}