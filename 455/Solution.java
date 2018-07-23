class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ret = 0;
        int gIndex = 0;
        int sIndex = 0;
        while(gIndex != g.length && sIndex != s.length){
            if(g[gIndex] <= s[sIndex]){
                ret += 1;
                gIndex += 1;
                sIndex += 1;
            } else {
                sIndex += 1;
            }
        }
        return ret;
    }
}