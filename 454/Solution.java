class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int cnt = 0;
        
        Map<Integer,Integer> ab = new HashMap();
        Map<Integer,Integer> cd = new HashMap();
        for(int a: A)
            for(int b: B)
                ab.put(a + b, ab.getOrDefault(a + b, 0) + 1);
        for(int c: C)
            for(int d: D)
                cd.put(c + d, cd.getOrDefault(c + d, 0) + 1);
        for(int k1: ab.keySet()){
            cnt += cd.getOrDefault(-k1, 0) * ab.get(k1);
        }
        return cnt;
    }
}
