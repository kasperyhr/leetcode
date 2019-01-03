class Solution {
    int cnt;
    public int countArrangement(int N) {
        Set<Integer> s = new HashSet<Integer>();
        cnt = 0;
        dfs(s, N, 0);
        return cnt;
    }
    
    private void dfs(Set<Integer> s, int N, int i){
        if(i == N){
            cnt++;
            return;
        }
        List<Integer> possible = poss(i + 1, N);
        for(int val: possible){
            if(!s.contains(val)){
                s.add(val);
                dfs(s, N, i+1);
                s.remove(val);
            }
        }
    }
    
    private List<Integer> poss(int i, int N){
        List<Integer> ret = new ArrayList<Integer>();
        for(int j = 1; j < i; j++) if(i % j == 0) ret.add(j);
        for(int j = 1; j * i <= N; j++) ret.add(j * i);
        return ret;
    }
}