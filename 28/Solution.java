class Solution {
    public int strStr(String haystack, String needle) {
        int len = needle.length();
        if(len == 0)
            return 0;
        for(int i = 0; i < haystack.length() - needle.length() + 1; i++){
            if(match(needle, haystack.substring(i)))
                return i;
        }
        return -1;
    }
    
    public static boolean match(String a, String b){
        // assume a is less than b
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i))
                return false;
        }
        return true;
    }
}