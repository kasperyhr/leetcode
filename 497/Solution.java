class Solution {
    int[] prefixSize;
    int[][] rects;
    int size;
    Random r;
    public Solution(int[][] rects) {
        this.rects = rects;
        r = new Random();
        prefixSize = new int[rects.length + 1];
        int prev = 0;
        for(int i = 1; i <= rects.length; i++){
            prefixSize[i] = prev + getSize(rects[i - 1]);
            prev = prefixSize[i];
        }
        size = prev;
    }
    
    public int getSize(int[] rect){
        return (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
    }
    
    public int[] getCoordinate(int[] rect, int val){
        int[] res = new int[2];
        res[0] = val % (rect[2] - rect[0] + 1) + rect[0];
        res[1] = val / (rect[2] - rect[0] + 1) + rect[1];
        return res;
    }
    
    public int[] pick() {
        int val = r.nextInt(size);
        int idx = Arrays.binarySearch(prefixSize, val);
        if(idx < 0){
            idx = -(idx + 1);
        } else {
            idx += 1;
        }
        val -= prefixSize[idx - 1];
        return getCoordinate(rects[idx - 1], val);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */