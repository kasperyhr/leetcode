class Solution {
    public int projectionArea(int[][] grid) {
        int view1 = 0;
        int view2 = 0;
        int view3 = 0;
        for(int i = 0; i < grid.length; i++){
            int view2High = 0;
            int view3High = 0;
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] > 0)
                    view1 += 1;
                view2High = Math.max(view2High, grid[i][j]);
                view3High = Math.max(view3High, grid[j][i]);
            }
            view2 += view2High;
            view3 += view3High;
        }
        return view1 + view2 + view3;
    }
}