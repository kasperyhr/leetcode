class Solution {
    public int maxSubArray(int[] nums) {
        TreeNode t = new TreeNode(0, nums.length - 1, nums);
        return t.max;
    }
    
    class TreeNode{
        int start;
        int end;
        int pre;
        int in;
        int post;
        int val = 0;
        int max = 0;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int start, int end, int[] nums){
            this.start = start;
            this.end = end;
            if(start == end)
                val = nums[start];
            if(start < end){
                int mid = (start + end) / 2;
                left = new TreeNode(start, mid, nums);
                right = new TreeNode(mid + 1, end, nums);
            }
            pre = (start == end) ? val : Math.max(left.pre, left.in + right.pre);
            in = (start == end) ? val : left.in + right.in;
            post = (start == end) ? val : Math.max(left.post + right.in, right.post);
            max = (start == end) ? val : Math.max(Math.max(left.max, right.max), left.post + right.pre);
            
        }
        
        public String toString(){
            String ret = "";
            if(start < end)
                ret += left.toString() + right.toString();
            ret += "Start: " + start;
            ret += " End: " + end;
            ret += " Pre: " + pre;
            ret += " In: " + in;
            ret += " Post: " + post;
            ret += " Max: " + max;
            ret += "\n";
            return ret;
        }
    }
    
}