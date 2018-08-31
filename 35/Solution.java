class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0 || target <= nums[0])
            return 0;
        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            int mid = (low + high) / 2;
            if(nums[mid] < target){
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        if(nums[low] < target){
            return low + 1;
        } else {
            return low;
        }

    }
}