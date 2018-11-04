class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        List<String> l = Arrays.asList(paragraph.split("[!|\\?|'|;|\\.|,| ]"));
        Map<String, Integer> m = new HashMap<String, Integer>();
        for(String s: l){
            if(s.length() == 0)
                continue;
            m.put(s, m.getOrDefault(s, 0) + 1);
        }
        for(String ban: banned){
            m.remove(ban);
        }
        int cnt = 0;
        String wrd = null;
        for(String k: m.keySet()){
            if(m.get(k) > cnt){
                cnt = m.get(k);
                wrd = k;
            }
        }
        return wrd;
    }
}