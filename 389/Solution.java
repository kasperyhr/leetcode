class Solution {
    public char findTheDifference(String s, String t) {
        int[] s2 = new int[26];
        int[] t2 = new int[26];
        toChar(s, s2);
        toChar(t, t2);
        for(int i = 0; i < 26; i++){
            if(s2[i] != t2[i])
                return (char)('a' + i);
        }
        return 'a';
    }
    
    private void toChar(String s, int[] s2){
        for(int i = 0; i < s.length(); i++){
            s2[s.charAt(i) - 'a'] += 1;
        }
    }
}