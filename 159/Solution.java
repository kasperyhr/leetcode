class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int len = 0;
        int left = 0;
        int ret = 0;
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        for(int right = 0; right < s.length(); right++){
            if(m.size() < 3)
                m.put(s.charAt(right), right);
            if(m.size() == 3){
                int val = Collections.min(m.values());
                m.remove(s.charAt(val));
                left = val + 1;
            }
            ret = Math.max(ret, right - left + 1);
        }
        return ret;
    }
}