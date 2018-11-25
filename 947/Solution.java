class Solution {
    public int removeStones(int[][] stones) {
        int ret = 0;
        boolean[] removed = new boolean[stones.length];
        for(int i = 0; i < stones.length; i++){
            if(!removed[i]){
                ret += 1;
                dfs(stones, removed, i);
            }
        }
        return stones.length - ret;
    }
    
    private void dfs(int[][] stones, boolean[] removed, int i){
        if(removed[i])
            return;
        removed[i] = true;
        for(int j = 0; j < stones.length; j++){
            // System.out.println(i + " " + stones[i][0] + " " + stones[i][1] + " " + j + " " + stones[j][0] + " " + stones[j][1]);
            if(j == i || removed[j]){
                // System.out.println("continue");
                continue;
            }
            if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                dfs(stones, removed, j);
            }
        }
    }
}
