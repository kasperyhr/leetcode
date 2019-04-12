class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        bt(n, cur, res, 2);
        return res;
    }
    
    public void bt(int n, List<Integer> cur, List<List<Integer>> res, int start){
        if(start > n) return;
        if(start == n){
            if(cur.size() > 0){
                cur.add(start);
                res.add(new ArrayList<>(cur));
                cur.remove(cur.size() - 1);
            }
            return;
        }
        if(n % start == 0){
            cur.add(start);
            bt(n / start, cur, res, start);
            cur.remove(cur.size() - 1);
        }
        bt(n, cur, res, nextFactor(n, start + 1));
    }
    
    public int nextFactor(int n, int start){
        while(start < n){
            if(n % start == 0)
                return start;
            start++;
        }
        return start;
    }
}