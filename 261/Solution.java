class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n != edges.length + 1)
            return false;
        Map<Integer, List<Integer>> m = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < edges.length; i++){
            List<Integer> l1 = m.getOrDefault(edges[i][0], new ArrayList<Integer>());
            l1.add(edges[i][1]);
            m.put(edges[i][0], l1);
            List<Integer> l2 = m.getOrDefault(edges[i][1], new ArrayList<Integer>());
            l2.add(edges[i][0]);
            m.put(edges[i][1], l2);
        }
        int cnt = 0;
        LinkedList<Integer> l = new LinkedList<Integer>();
        boolean[] a = new boolean[n];
        l.addLast(0);
        a[0] = true;
        while(l.size() > 0){
            int i = l.removeFirst();
            cnt++;
            if(m.get(i) != null){
                for(int j : m.get(i)){
                    if(!a[j]){
                        a[j] = true;
                        l.addLast(j);
                    }
                }
            }
        }
        return cnt == n;
    }
}