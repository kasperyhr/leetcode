class Solution {
    Set<Integer> ret;
    Map<Integer, List<Integer>> m;
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        m = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < pid.size(); i++){
            List<Integer> l = m.getOrDefault(ppid.get(i), new LinkedList<Integer>());
            l.add(pid.get(i));
            m.put(ppid.get(i), l);
        }
        ret = new HashSet<Integer>();
        dfs(kill);
        return new ArrayList(ret);
    }
    private void dfs(int k){
        if(ret.contains(k))
            return;
        ret.add(k);
        if(m.containsKey(k)){
            List<Integer> l = m.get(k);
            for(int i : l){
                dfs(i);
            }
        }
    }
}