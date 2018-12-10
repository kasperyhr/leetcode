class Solution {
    public String minWindow(String s, String t) {
        int currLen = s.length() + 2;
        String ret = "";
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        for(int i = 0; i < t.length(); i++) m.put(t.charAt(i), m.getOrDefault(t.charAt(i), 0) + 1);
        int l = 0, r = 0;
        Map<Character, Integer> m1 = new HashMap<Character, Integer>();
        int processed = 0;
        int target = m.size();
        while(r < s.length()){
            char c = s.charAt(r);
            m1.put(c, m1.getOrDefault(c, 0) + 1);
            if(m.containsKey(c) && m.get(c).intValue() == m1.get(c).intValue()) processed++;
            while(l <= r && processed == target){
                if(r - l + 1 < currLen){
                    currLen = r - l + 1;
                    ret = s.substring(l, r + 1);
                }
                c = s.charAt(l);
                m1.put(c, m1.get(c) - 1);
                if(m.containsKey(c) && m.get(c).intValue() > m1.get(c).intValue()) processed--;
                l++;
            }
            r++;
        }
        return ret;
    }
}