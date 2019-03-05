class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<Integer>();
        Set<Integer> s2 = new HashSet<Integer>();
        for(int num: nums1){
            s1.add(num);
        }
        
        for(int num: nums2){
            s2.add(num);
        }
        
        s1.retainAll(s2);
        int[] ret = new int[s1.size()];
        int ptr = 0;
        for(int num: s1) ret[ptr++] = num;
        return ret;
    }
}