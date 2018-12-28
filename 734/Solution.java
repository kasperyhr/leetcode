class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if(words1.length != words2.length)
            return false;
        Map<String, Set<String>> m = new HashMap<String, Set<String>>();
        for(int i = 0; i < pairs.length; i++){
            Set<String> s1 = m.getOrDefault(pairs[i][0], new HashSet<String>());
            s1.add(pairs[i][1]);
            m.put(pairs[i][0], s1);
            Set<String> s2 = m.getOrDefault(pairs[i][1], new HashSet<String>());
            s2.add(pairs[i][0]);
            m.put(pairs[i][1], s2);
        }
        for(int i = 0; i < words1.length; i++){
            if(words1[i].equals(words2[i]) || m.get(words1[i]) != null && m.get(words1[i]).contains(words2[i]))
                continue;
            else return false;
                
        }
        return true;
    }
}