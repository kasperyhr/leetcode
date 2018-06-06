class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        if(strs.length == 1)
            return strs[0];
        String common = strs[0];
        for(int i = 1; i < strs.length; i++){
            common = commonPrefix(common, strs[i]);
            if(common.length() == 0)
                return "";
        }
        return common;
    }
    
    public String commonPrefix(String s1, String s2){
        if(s1.length() == 0)
            return "";
        if(s2.length() == 0)
            return "";
        boolean isS1Longer = s1.length() > s2.length();
        String ret = "";
        int index = 0;
        if(isS1Longer){
            while(index < s2.length()){
                if(s1.charAt(index) == s2.charAt(index))
                    index++;
                else
                    break;
            }
            ret = s1.substring(0, index);
        } else {
            while(index < s1.length()){
                if(s1.charAt(index) == s2.charAt(index))
                    index++;
                else
                    break;
            }
            ret = s1.substring(0, index);
        }
        return ret;
    }
}