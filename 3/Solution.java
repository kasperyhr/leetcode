class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        int currmax = 0;
        while(currmax <= s.length()){
            String sub = s.substring(0, currmax);
            if(isRepeat(sub))
                s = s.substring(1);
            else
                currmax = currmax + 1;
        }
        return currmax - 1;
    }
    
    public static boolean isRepeat(String s){
        if(s.length() == 0)
            return false;
        for(int i = 0; i < s.length(); i++){
            for(int j = i + 1; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j))
                    return true;
            }
        }
        return false;
    }
}