class Solution {
    static final int SIZE = 26;
    public boolean isAnagram(String s, String t) {
        int[] cnt = new int[SIZE];
        if(s.length() != t.length())
            return false;
        for(int i = 0; i < s.length(); i++){
            cnt[s.charAt(i) - 'a']++;
            cnt[t.charAt(i) - 'a']--;
        }
        for(int i = 0; i < SIZE; i++){
            if(cnt[i] != 0)
                return false;
        }
        return true;
    }
}
