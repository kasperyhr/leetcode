class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1)
            return 0;
        int low = 0;
        int high = nums.length - 1;
        if(nums[low] > nums[low + 1])
            return 0;
        if(nums[high] > nums[high - 1])
            return high;
        while(low < high){
            int mid = (low + high) / 2;
            if(mid == 0)
                return 1;
            if(nums[mid - 1] > nums[mid])
                high = mid - 1;
            else if(nums[mid] < nums[mid + 1])
                low = mid + 1;
            else
                return mid;
        }
        return low;
    }
}