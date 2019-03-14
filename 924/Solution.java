class Solution {
    int[] father;
    int[] size;
    int[] cnt;
    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        int i, j;
        father = new int[n];
        size = new int[n];
        cnt = new int[n];
        for(i = 0; i < n; ++i){
            father[i] = i;
            size[i] = 1;
        }
        for(i = 0; i < initial.length; ++i){
            cnt[initial[i]] = 1;
        }
        
        // Initial father
        int fi, fj;
        for(i = 0; i < n; ++i){
            for(j = i + 1; j < n; ++j){
                if(graph[i][j] == 1){
                    fi = find(i);
                    fj = find(j);
                    if(fi != fj){
                        union(i, j);
                    }
                }
            }
        }
        Arrays.sort(initial);
        int max_size = size[find(initial[0])];
        int idx = initial[0];
        for(i = 0; i < initial.length; i++){
            if(size[find(initial[i])] > max_size && cnt[find(initial[i])] == 1){
                max_size = size[find(initial[i])];
                idx = initial[i];
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
            i = father[i];
        }
        return val;
    }
    
    private void union(int i, int j){
        int fi = find(i);
        int fj = find(j);
        if(fi != fj){
            father[fi] = fj;
            size[fj] += size[fi];
            cnt[fj] += cnt[fi];
        }
    }
}