class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret = new ArrayList<Integer>();
        int sLen = s.length();
        int pLen = p.length();
        if(sLen < pLen)
            return ret;
        boolean flag = false;
        for(int i = 0; i <= sLen - pLen; i++){
            if(flag){
                char c1 = s.charAt(i - 1);
                char c2 = s.charAt(i + pLen - 1);
                if(c1 == c2)
                    ret.add(i);
                else
                    flag = false;
            } else {
                int val = check(s.substring(i, i + pLen), p);
                if(val == -1){
                    flag = true;
                    ret.add(i);
                } else {
                    i += val;
                }
            }
        }
        return ret;
    }
    
    // return the last index in s not in p. If all letters occured in p, then we retrun -1.
    private int check(String s, String p){
        // Store all the letters in the array.
        int[] v = new int[26];
        for(int i = 0; i < p.length(); i++){
            v[p.charAt(i) - 'a']++;
        }
        for(int i = s.length() - 1; i >= 0; i--){
            v[s.charAt(i) - 'a']--;
            if(v[s.charAt(i) - 'a'] < 0)
                return i;
        }
        return -1;
        
    }
}