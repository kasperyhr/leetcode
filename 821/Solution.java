class Solution {
    public int[] shortestToChar(String S, char C) {
        int[] ret = new int[S.length()];
        ArrayList<Integer> l = new ArrayList<Integer>();
        for(int i = 0; i < S.length(); i++) if(S.charAt(i) == C) l.add(i);
        int p = 0;
        for(int i = 0; i < S.length(); i++){
            if(p == 0)
                ret[i] = l.get(p) - i;
            else if(p <= l.size() - 1)
                ret[i] = Math.min(l.get(p) - i, i - l.get(p - 1));
            else
                ret[i] = i - l.get(p - 1);
            if(p <= l.size() - 1 && l.get(p) == i) p++;
        }
        return ret;
    }
}