class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> m = new HashMap<String, Integer>();
        for(String s: A.split(" ")) m.put(s, m.getOrDefault(s, 0) + 1);
        for(String s: B.split(" ")) m.put(s, m.getOrDefault(s, 0) + 1);
        ArrayList<String> ret = new ArrayList<String>();
        for(String key: m.keySet()) if(m.get(key) == 1) ret.add(key);
        return ret.toArray(new String[]{});
    }
}