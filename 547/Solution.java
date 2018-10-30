class Solution {
    Set<Integer> visited;
    public int findCircleNum(int[][] M) {
        visited = new HashSet<Integer>();
        int N = M.length;
        int cnt = 0;
        for(int i = 0; i < N; i++){
            if(!visited.contains(i)){
                cnt += 1;
                dfs(M, N, i);
            }
        }
        return cnt;
    }
    
    private void dfs(int[][] M, int N, int i){
        if(visited.contains(i))
            return;
        visited.add(i);
        for(int j = 0; j < N; j++){
            if(M[i][j] == 1)
                dfs(M, N, j);
        }
    }
}