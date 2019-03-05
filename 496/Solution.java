class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<Integer>();
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums2.length; i++){
            while(!s.isEmpty()){
                int curr = s.peek();
                if(curr < nums2[i]){
                    m.put(curr, nums2[i]);
                    s.pop();
                } else {
                    break;
                }
            }
            s.push(nums2[i]);
        }
        int[] ret = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            ret[i] = m.getOrDefault(nums1[i], -1);
        }
        return ret;
    }
}