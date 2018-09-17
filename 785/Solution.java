class Solution {
    public boolean isBipartite(int[][] graph) {
        if(graph.length == 0)
            return true;
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] isBlack = new boolean[n];
        Queue<Integer> q = new LinkedList();
        for(int pt = 0; pt < graph.length; pt++){
            if(visited[pt])
                continue;
            q.offer(pt);
            visited[pt] = true;
            while(!q.isEmpty()){
                int a = q.poll();
                boolean col = !isBlack[a];
                for(int i = 0; i < graph[a].length; i++){
                    if(!visited[graph[a][i]]){
                        visited[graph[a][i]] = true;
                        isBlack[graph[a][i]] = col;
                        q.offer(graph[a][i]);
                    } else {
                        if(isBlack[graph[a][i]] != col)
                            return false;
                    }
                }
            }
        }
        return true;
    }
}