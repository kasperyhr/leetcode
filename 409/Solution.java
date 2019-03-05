class Solution {
    public int longestPalindrome(String s) {
        int ret = 0;
        Set<Character> set = new HashSet<Character>();
        for(int i = 0; i < s.length(); i++){
            if(set.contains(s.charAt(i))){
                set.remove(s.charAt(i));
                ret += 2;
            } else {
                set.add(s.charAt(i));
            }
        }
        if(set.size() > 0) ret += 1;
        return ret;
    }
    
}