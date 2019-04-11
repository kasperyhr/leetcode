class Solution {
    Map<Integer, Integer> m;
    int size, total;
    int n_rows, n_cols;
    Random r;
    public Solution(int n_rows, int n_cols) {
        m = new HashMap<>();
        this.n_rows = n_rows;
        this.n_cols = n_cols;
        total = n_rows * n_cols;
        size = 0;
        r = new Random();
    }
    
    public int[] flip() {
        int val = r.nextInt(total--);
        int tmp = val;
        while(m.containsKey(tmp))
            tmp = m.get(tmp);
        while(m.containsKey(val) && m.get(val) != tmp){
            int t = m.get(val);
            m.put(val, total);
            val = t;
        }
        m.put(tmp, total);
        return new int[]{tmp % n_rows, tmp / n_rows};
    }
    
    public void reset() {
        size = 0;
        total = n_rows * n_cols;
        m = new HashMap<>();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n_rows, n_cols);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */