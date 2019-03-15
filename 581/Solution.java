class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length <= 1) return 0;
        Stack<Integer> s = new Stack();
        int i, n = nums.length, l = n, r = 0;
        for(i = 0; i < n; i++){
            while(!s.isEmpty() && nums[s.peek()] > nums[i]) l = Math.min(l, s.pop());
            s.push(i);
        }
        s.clear();
        
        for(i = n - 1; i >= 0; i--){
            while(!s.isEmpty() && nums[s.peek()] < nums[i]) r = Math.max(r, s.pop());
            s.push(i);
        }
        if(r > l) return r - l + 1;
        return 0;
    }
}