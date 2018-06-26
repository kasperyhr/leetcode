class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        if(s.length() == 0)
            return true;
        int first = 0;
        char f = s.charAt(first);
        int last = s.length() - 1;
        char l = s.charAt(last);
        while(first < last){
            for(; first < s.length(); first++){
                f = s.charAt(first);
                if(Character.isLetterOrDigit(f))
                    break;
            }
            for(; last >= 0; last--){
                l = s.charAt(last);
                if(Character.isLetterOrDigit(l))
                    break;
            }
            if(first >= last)
                return true;
            if(f == l){
                first += 1;
                last -= 1;
            } else {
                return false;
            }
        }
        return true;
    }
}