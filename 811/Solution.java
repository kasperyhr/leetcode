class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> m = new HashMap<String, Integer>();
        for(String s: cpdomains){
            String[] ss = s.split(" ");
            int cnt = Integer.parseInt(ss[0]);
            String[] sss = ss[1].split("\\.");
            String domain = "";
            for(int i = sss.length - 1; i >= 0; i--){
                if(domain.length() == 0){
                    domain = sss[i] + domain;
                } else {
                    domain = sss[i] + '.' + domain;
                }
                m.put(domain, m.getOrDefault(domain, 0) + cnt);
            }
        }
        List<String> ret = new LinkedList<String>();
        for(String key: m.keySet()){
            String s = m.get(key) + " " + key;
            ret.add(s);
        }
        return ret;
    }
}