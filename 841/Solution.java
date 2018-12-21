class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int N = rooms.size();
        boolean[] unlock = new boolean[N];
        dfs(rooms, unlock, 0);
        for(int i = 0; i < N; i++){
            if(!unlock[i])
                return false;
        }
        return true;
    }
    
    private void dfs(List<List<Integer>> rooms, boolean[] unlock, int i){
        unlock[i] = true;
        for(int j: rooms.get(i)){
            if(!unlock[j])
                dfs(rooms, unlock, j);
        }
    }
}