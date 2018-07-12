class Solution {
    public String toLowerCase(String str) {
        StringBuilder ret = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c >= 'A' && c <= 'Z')
                ret.append((char)(c - 'A' + 'a'));
            else
                ret.append(c);
        }
        return new String(ret);
    }
}