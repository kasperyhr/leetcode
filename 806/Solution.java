class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int line = 1;
        int pad = 0;
        for(char c: S.toCharArray()){
            if(widths[c - 'a'] + pad > 100) {line++; pad = widths[c - 'a'];}
            else pad+=widths[c - 'a'];
        } 
        return new int[]{line, pad};
    }
}