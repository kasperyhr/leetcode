class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int len = Integer.MAX_VALUE;
        
        int ptr1 = 0, ptr2 = 0, sum = 0;
        
        while(sum < s && ptr2 < nums.length){
            sum+=nums[ptr2++];
            if(sum >= s){
                while(ptr1 < ptr2 && sum >= s){
                    sum -= nums[ptr1++];
                }
                len = Math.min(ptr2 - ptr1 + 1, len);
            }
        }
        
        if(len == Integer.MAX_VALUE) len = 0;
        return len;
    }
}