class Solution {
    public int search(int[] nums, int target) {
        int low     = 0;
        int high    = nums.length - 1;
        while(low <= high){
            int medium = (low + high) / 2;
            if(nums[medium] == target)
                return medium;
            if(nums[low] <= nums[medium]){
                if(nums[low] <= target && target < nums[medium])
                    high = medium - 1;
                else
                    low = medium + 1;
            } else {
                if(nums[medium] < target && target <= nums[high])
                    low = medium + 1;
                else
                    high = medium - 1;
            }
        }
        return -1;
    }
}