class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ret = new ArrayList();
        for(String word: words){
            if(match(word, pattern)) ret.add(word);
        }
        return ret;
    }
    
    private boolean match(String s1, String s2){
        Map<Character, Character> m12 = new HashMap();
        Map<Character, Character> m21 = new HashMap();
        if(s1.length() != s2.length()) return false;
        int i, n;
        char c1, c2;
        n = s1.length();
        for(i = 0; i < n; i++){
            c1 = s1.charAt(i);
            c2 = s2.charAt(i);
            if(!m12.containsKey(c1) && !m21.containsKey(c2)){
                m12.put(c1, c2);
                m21.put(c2, c1);
            } else if(m12.containsKey(c1) && m21.containsKey(c2)){
                if(m12.get(c1) == c2 && m21.get(c2) == c1){
                    continue;
                } else {
                    return false;
                }
            } else return false;
        }
        
        return true;
    }
}