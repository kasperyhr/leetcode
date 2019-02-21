class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<Integer>();
        for(int num: nums)
            s.add(num);
        int ret = 0;
        for(int num: s){
            if(!s.contains(num - 1)){
                int len = 1;
                int val = num + 1;
                while(s.contains(val)){
                    len++; val++;
                }
                ret = Math.max(ret, len);
            }
        }
        return ret;
    }
}