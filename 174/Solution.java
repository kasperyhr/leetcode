class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] health = new int[dungeon.length][dungeon[0].length];
        
        health[dungeon.length - 1][dungeon[0].length - 1] = Math.max(1, 1 - dungeon[dungeon.length - 1][dungeon[0].length - 1]);
        
        for(int i = dungeon.length - 2; i >= 0; i--){
            health[i][dungeon[0].length - 1] = Math.max(1, health[i + 1][dungeon[0].length - 1] - dungeon[i][dungeon[0].length - 1]);
        }
        
        for(int j = dungeon[0].length - 2; j >= 0; j--){
            health[dungeon.length - 1][j] = Math.max(1, health[dungeon.length - 1][j + 1] - dungeon[dungeon.length - 1][j]);
        }
        
        for(int i = dungeon.length - 2; i >= 0; i--){
            for(int j = dungeon[0].length - 2; j >= 0; j--){
                health[i][j] = Math.max(1, Math.min(health[i + 1][j], health[i][j + 1]) - dungeon[i][j]);
            }
        }
        return health[0][0];
    }
}