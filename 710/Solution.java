class Solution {
    
    Map<Integer, Integer> m;
    Random r;
    int size;
    public Solution(int N, int[] blacklist) {
        r = new Random();
        m = new HashMap<Integer, Integer>();
        Set<Integer> w = new HashSet<Integer>();
        size = N - blacklist.length;
        for(int i = size; i < N; i++) w.add(i);
        for(int i: blacklist) w.remove(i);
        Iterator<Integer> iter = w.iterator();
        for(int i = 0; i < blacklist.length; i++)
            if(blacklist[i] < size)
                m.put(blacklist[i], iter.next());
    }
    
    public int pick() {
        int val = r.nextInt(size);
        return m.getOrDefault(val, val);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(N, blacklist);
 * int param_1 = obj.pick();
 */