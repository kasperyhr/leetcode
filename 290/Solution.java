class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] lst = str.split(" ");
        if(lst.length != pattern.length())
            return false;
        Map<Character, String> m1 = new HashMap<Character, String>();
        Map<String, Character> m2 = new HashMap<String, Character>();
        for(int i = 0; i < lst.length; i++){
            char c = pattern.charAt(i);
            String s = lst[i];
            if(m1.get(c) == null && m2.get(s) == null){
                m1.put(c, s);
                m2.put(s, c);
            } else if(s.equals(m1.get(c)) && m2.get(s) == c){
                continue;
            } else{
                return false;
            }
        }
        return true;
    }
}