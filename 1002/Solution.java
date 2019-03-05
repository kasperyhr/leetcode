class Solution {
    public List<String> commonChars(String[] A) {
        List<String> ret = new ArrayList<String>();
        if(A == null || A.length == 0)
            return ret;
        int[] len = cnt(A[0]);
        for(int i = 1; i < A.length; i++){
            int[] len1 = cnt(A[i]);
            for(int j = 0; j < 26; j++){
                len[j] = Math.min(len[j], len1[j]);
            }
        }
        for(int j = 0; j < 26; j++){
            while(len[j] > 0){
                len[j] -= 1;
                ret.add("" + (char)('a' + j));
            }
        }
        return ret;
    }
    
    private int[] cnt(String s){
        int[] len = new int[26];
        for(int i = 0; i < s.length(); i++){
            int j = (int)(s.charAt(i) - 'a');
            len[j] += 1;
        }
        return len;
    }
}