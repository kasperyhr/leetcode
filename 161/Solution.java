class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s.length() - t.length() == 1){
            boolean flag = false;
            for(int i = 0; i < t.length(); i++){
                if(!flag){
                    if(s.charAt(i) != t.charAt(i)){
                        flag = true;
                        i--;
                    }
                } else {
                    if(s.charAt(i + 1) != t.charAt(i))
                        return false;
                }
            }
            return true;
        } else if(t.length() - s.length() == 1){
            boolean flag = false;
            for(int i = 0; i < s.length(); i++){
                if(!flag){
                    if(s.charAt(i) != t.charAt(i)){
                        flag = true;
                        i--;
                    }
                } else {
                    if(t.charAt(i + 1) != s.charAt(i))
                        return false;
                }
            }
            return true;
        } else if(t.length() == s.length()){
            boolean flag = false;
            for(int i = 0; i < s.length(); i++){
                if(!flag){
                    if(s.charAt(i) != t.charAt(i)) flag = true;
                } else {
                    if(t.charAt(i) != s.charAt(i)) return false;
                }
            }
            return flag;
        }
        return false;
    }
}