class Solution {
    public List<String> letterCasePermutation(String S) {
        char[] s = S.toLowerCase().toCharArray();
        List<String> ret = new ArrayList();
        backtrack(s, 0, ret);
        return ret;
    }
    
    public void backtrack(char[] s, int index, List<String> l){
        if(index == s.length){
            l.add(new String(s));
            return;
        }
        backtrack(s, index + 1, l);
        if(Character.isLowerCase(s[index])){
            s[index] = (char) (s[index] & 223);
            backtrack(s, index + 1, l);
            s[index] = (char) (s[index] | 32);
        }
    }
    
}