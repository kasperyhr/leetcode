class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int cnt = 0, ptr1 = 0, ptr2 = 0;
        while(ptr2 < abbr.length() && ptr1 < word.length()){
            char c1 = word.charAt(ptr1);
            char c2 = abbr.charAt(ptr2);
            if(Character.isDigit(c2)){
                if(cnt == 0 && c2 == '0') return false;
                cnt = cnt * 10 + (c2 - '0');
                ptr2++;
            } else {
                if(cnt != 0){
                    ptr1 += cnt;
                    cnt = 0;
                }
                if(ptr1 < word.length()){
                    c1 = word.charAt(ptr1);
                    if(c1 != c2){
                        return false;
                    }
                    ptr1++;
                    ptr2++;
                } else {
                    return false;
                }
            }
        }
        if(cnt != 0){
            ptr1 += cnt;
            cnt = 0;
        }
        if(ptr2 == abbr.length() && ptr1 == word.length()) return true;
        return false;
    }
}