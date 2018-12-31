class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> m = new HashMap<Integer, List<Integer>>();
        for(int[] edge: edges){
            List<Integer> l1 = m.getOrDefault(edge[0], new ArrayList<Integer>());
            l1.add(edge[1]);
            m.put(edge[0], l1);
            List<Integer> l2 = m.getOrDefault(edge[1], new ArrayList<Integer>());
            l2.add(edge[0]);
            m.put(edge[1], l2);
        }
        boolean[] f = new boolean[n];
        int ret = 0;
        for(int i = 0; i < n; i++){
            if(!f[i]){
                ret++;
                dfs(i, f, m);
            }
        }
        return ret;
    }
    
    private void dfs(int i, boolean[] f, Map<Integer, List<Integer>> m){
        f[i] = true;
        List<Integer> l = m.getOrDefault(i, new ArrayList<Integer>());
        for(int j: l){
            if(!f[j])
                dfs(j, f, m);
        }
        return;
    }
}