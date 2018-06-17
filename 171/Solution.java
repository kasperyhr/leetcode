class Solution {
    public int titleToNumber(String s) {
        int ret = 0;
        for(int i = 0; i < s.length(); i++){
            ret *= 26;
            ret += s.charAt(i) - 'A' + 1;
        }
        return ret;
    }
}