class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> m1 = new HashMap<Character, Character>();
        Map<Character, Character> m2 = new HashMap<Character, Character>();
        for(int i = 0; i < s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(m1.containsKey(c1) && m2.containsKey(c2)){
                if(m1.get(c1) != c2)
                    return false;
            } else if(m1.containsKey(c1) || m2.containsKey(c2)){
                return false;
            } else {
                m1.put(c1, c2);
                m2.put(c2, c1);
            }
        }
        return true;
    }
}