class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] c2 = count(licensePlate);
        String ret = "";
        for(int i = 0; i < words.length; i++) if ((ret.length() == 0 || words[i].length() < ret.length()) && beat(count(words[i]), c2)) ret = words[i];
        return ret;
    }
    
    private boolean beat(int[] c1, int[] c2){
        for(int i = 0; i < 26; i++) if(c1[i] < c2[i]) return false;
        return true;
    }
    
    private int[] count(String s){
        s = s.toLowerCase();
        int[] ret = new int[26];
        for(char c: s.toCharArray()) if(c >= 'a' && c <= 'z') ret[c - 'a']++;
        return ret;
    }
}