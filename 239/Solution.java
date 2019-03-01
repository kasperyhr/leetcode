class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 0 || nums.length == 0) return new int[0];
        int[] ret = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<Integer>();
        for(int i = 0; i < nums.length; i++){
            while(!q.isEmpty() && q.peek() < i - k + 1) q.poll();
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]) q.pollLast();
            q.add(i);
            if(i >= k - 1) ret[i - k + 1] = nums[q.peek()];
        }
        return ret;
    }
}