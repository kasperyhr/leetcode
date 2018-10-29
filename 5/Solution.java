class Solution {
    public String longestPalindrome(String s) {
        int currStartIdx    = 0;
        int currLen         = 0;
        
        if(s.length() < 2)
            return s;
        
        for(int i = 0; i < s.length(); i++){
            int startIdx, endIdx, len;
            // find the maximum palindrome with odd length with the middle index is i.
            startIdx            = i;
            endIdx              = i;
            while(startIdx >= 0 && endIdx < s.length() && s.charAt(startIdx) == s.charAt(endIdx)){
                startIdx --;
                endIdx ++;
            }
            len = endIdx - startIdx - 1;
            if(currLen < len){
                currLen         = len;
                currStartIdx    = startIdx + 1;
            }
            // find the maximum palindrome with even length with the middle two index is i and i + 1.
            startIdx            = i;
            endIdx              = i + 1;
            while(startIdx >= 0 && endIdx < s.length() && s.charAt(startIdx) == s.charAt(endIdx)){
                startIdx --;
                endIdx ++;
            }
            len = endIdx - startIdx - 1;
            if(currLen < len){
                currLen         = len;
                currStartIdx    = startIdx + 1;
            }
        }
        return s.substring(currStartIdx, currStartIdx + currLen);
    }
}
