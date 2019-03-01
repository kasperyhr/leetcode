class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> m = new HashMap<String, List<String>>();
        for(int i = 0; i < strings.length; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(strings[i].length());
            for(int j = 1; j < strings[i].length(); j++){
                sb.append("->");
                int val = (strings[i].charAt(j) - strings[i].charAt(j - 1));
                val = val < 0 ? val + 26 : val;
                sb.append(val);
            }
            String s = sb.toString();
            List<String> l = m.getOrDefault(s, new ArrayList<String>());
            l.add(strings[i]);
            m.put(s, l);
        }
        List<List<String>> ret = new ArrayList<List<String>>(m.values());
        return ret;
    }
}