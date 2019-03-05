class Solution {
    public int findJudge(int N, int[][] trust) {
        Set<Integer> s = new HashSet<Integer>();
        for(int i = 1; i <= N; i++){
            s.add(i);
        }
        for(int[] t: trust){
            s.remove(t[0]);
        }
        if(s.size() != 1) return -1;
        int val = s.iterator().next();
        for(int[] t: trust){
            if(t[1] == val) N--;
        }
        if(N == 1) return val;
        return -1;
    }
}