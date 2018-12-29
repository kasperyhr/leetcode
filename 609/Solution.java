class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> m = new HashMap<String, List<String>>();
        for(String path: paths){
            String[] sp = path.split(" ");
            for(int i = 1; i < sp.length; i++){
                String name = sp[i].split("[(|)]")[0];
                String content = sp[i].split("[(|)]")[1];
                String curr_Path = sp[0] + "/" + name;
                List<String> l = m.getOrDefault(content, new ArrayList<String>());
                l.add(curr_Path);
                m.put(content, l);
            }
        }
        List<List<String>> ret = new ArrayList<List<String>>();
        for(String key: m.keySet()){
            if(m.get(key).size() > 1){
                ret.add(m.get(key));
            }
        }
        return ret;
    }
}