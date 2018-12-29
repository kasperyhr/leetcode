class Solution {
    public String reverseWords(String s) {
        String[] ss = s.split(" ");
        String ret = "";
        for(String s0: ss) ret += new StringBuilder(s0).reverse().toString() + " ";
        ret = ret.trim();
        return ret;
    }
}