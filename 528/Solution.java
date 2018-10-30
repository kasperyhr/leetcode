class Solution {
    int[] m;
    int max;
    public Solution(int[] w) {
        m = new int[w.length];
        for(int i = 0; i < w.length; i++){
            m[i] = w[i];
            max += m[i];
        }
    }
    
    public int pickIndex() {
        double rand = Math.random() * max;
        int i = 0;
        rand -= m[0];
        while(rand > 0){
            i ++;
            rand -= m[i];
        }
        return i;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */