class Solution {
    public void nextPermutation(int[] nums) {
        // idea: dictionary sort
        // base case
        if(nums.length < 2)
            return;
        // first: starting from the last index find the non-decreasing sublist.
        // i.e. [1,3,2,6,5,4] would find out index 3 since 6,5,4 is the last non-decreasing sublist from the last index.
        int pivot = nums.length - 1;
        while(pivot > 0){
            if(nums[pivot] > nums[pivot - 1])
                break;
            pivot -= 1;
        }
        if(pivot == 0){
            // consider edge case, this is the largest permutation, next permutation would be the reverse of the list;
            reverse(nums, 0);
        } else {
            // second: find the smallest number in the sublist which is greater than nums[pivot - 1]
            // it is guaranteed that there exists such number since nums[pivot - 1] < nums[pivot]
            int maxIndex = pivot;
            // this while loop would at least execute once.
            while(maxIndex < nums.length && nums[maxIndex] > nums[pivot - 1]){
                maxIndex += 1;
            }
            maxIndex -= 1;
            // third: swap nums[pivot - 1] and nums[maxIndex]
            nums[pivot - 1] = nums[pivot - 1] + nums[maxIndex];
            nums[maxIndex] = nums[pivot - 1] - nums[maxIndex];
            nums[pivot - 1] = nums[pivot - 1] - nums[maxIndex];
            // last: reverse the list starting from pivot
            reverse(nums, pivot);
        }
            
    }
    
    public static void reverse(int[] nums, int startIndex){
        // The first startIndex elements in nums would not reverse, begining with index startIndex, the rest of the list would be reverse
        // i.e. [1,2,3,4,5,6] and 1 would have [1,6,5,4,3,2]
        int revLen = (nums.length - startIndex) / 2;
        for(int i = 0; i < revLen; i++){
            // swap two elements in the list
            nums[startIndex + i] = nums[startIndex + i] + nums[nums.length - i - 1];
            nums[nums.length - i - 1] = nums[startIndex + i] - nums[nums.length - i - 1];
            nums[startIndex + i] = nums[startIndex + i] - nums[nums.length - i - 1];
        }
    }
}