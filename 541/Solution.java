class Solution {
    public String reverseStr(String s, int k) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < s.length(); i += 2 * k){
            sb.append(new StringBuffer(s.substring(i, Math.min(i + k, s.length()))).reverse());
            sb.append(s.substring(Math.min(i + k, s.length()), Math.min(i + 2 * k, s.length())));
        }
        return sb.toString();
    }
}