class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<String, List<String>>();
        for(String str: strs){
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String s = new String(chs);
            List<String> ls = m.getOrDefault(s, new ArrayList<String>());
            ls.add(str);
            m.put(s, ls);
        }
        return new ArrayList<List<String>>(m.values());
    }
}