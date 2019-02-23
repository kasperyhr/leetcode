class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int ret = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            ret += twoSumSmaller(nums, i + 1, target - nums[i]);
        }
        return ret;
    }
    
    public int twoSumSmaller(int[] nums, int start, int target){
        int ptr1 = start, ptr2 = nums.length - 1, ret = 0;
        while(ptr1 < ptr2){
            if(nums[ptr1] + nums[ptr2] < target){
                ret += ptr2 - ptr1;
                ptr1++;
            } else {
                ptr2--;
            }
        }
        return ret;
    }
}