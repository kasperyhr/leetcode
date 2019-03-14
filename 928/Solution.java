class Solution {
    int[] father;
    int[] size;
    int[] cnt;
    public int minMalwareSpread(int[][] graph, int[] initial) {
        Arrays.sort(initial);
        int n = graph.length;
        int i, j, fi, fj;
        
        Set<Integer> affected = new HashSet();
        for(int num: initial){
            affected.add(num);
        }
        //Initial father
        father = new int[n];
        size = new int[n];
        cnt = new int[n];
        for(i = 0; i < n; i++){
            father[i] = i;
            size[i] = 1;    
        }
        for(i = 0; i < n; i++)
            if(!affected.contains(i))
                for(j = 0; j < n; j++)
                    if(!affected.contains(j))
                        if(graph[i][j] == 1)
                            union(i, j);
        Map<Integer, Set<Integer>> m = new HashMap();
        for(int affect: initial){
            Set<Integer> s = new HashSet();
            for(j = 0; j < n; j++)
                if(!affected.contains(j) && graph[affect][j] == 1)
                    s.add(find(j));
            
            m.put(affect, s);
            for(int node: s){
                cnt[node]++;
            }
        }
        
        int idx = -1;
        int max_size = -1;
        for(int init: initial){
            int val = 0;
            for(int node: m.get(init)){
                if(cnt[node] == 1){
                    val += size[node];
                }
            }
            if(val > max_size){
                idx = init;
                max_size = val;
            }
        }
        return idx;
    }
    
    private int find(int i){
        int val = i;
        int tmp;
        while(father[val] != val){
            val = father[val];
        }
        
        while(i != val){
            tmp = father[i];
            father[i] = val;
            i = tmp;
        }
        return val;
    }
    
    private void union(int i, int j){
        int fi, fj;
        fi = find(i);
        fj = find(j);
        if(fi != fj){
            father[fi] = fj;
            size[fj] += size[fi];
        }
    }
}