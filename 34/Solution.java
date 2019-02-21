class Solution {
    public int[] searchRange(int[] nums, int target) {
        int val = Arrays.binarySearch(nums, target);
        if(val <= -1) return new int[]{-1, -1};
        int[] ret = {findFirst(nums, target), findLast(nums, target)};
        return ret;
    }
    
    private int findFirst(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            // System.out.print("Hi");
            int mid = (low + high) / 2;
            if(nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        if(low >= 0 && low < nums.length && nums[low] == target)
            return low;
        return low + 1;
    }
    
    private int findLast(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            // System.out.print("bye");
            int mid = (low + high) / 2;
            if(nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        if(low >= 0 && low < nums.length && nums[low] == target)
            return low;
        return low - 1;
    }
}