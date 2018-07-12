class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private void dfs(int[][] image, int i, int j, int originColor, int newColor){
        if(i < 0 || i >= image.length)
            return;
        if(j < 0 || j >= image[0].length)
            return;
        if(image[i][j] != originColor)
            return;
        image[i][j] = -1;
        dfs(image, i + 1, j, originColor, newColor);
        dfs(image, i - 1, j, originColor, newColor);
        dfs(image, i, j + 1, originColor, newColor);
        dfs(image, i, j - 1, originColor, newColor);
        image[i][j] = newColor;
    }
}