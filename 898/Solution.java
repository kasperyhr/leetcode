class Solution {
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> cur = new HashSet<>();
        for(int x: A){
            Set<Integer> s = new HashSet<>();
            for(int y: cur){
                s.add(y | x);
            }
            s.add(x);
            res.addAll(s);
            cur = s;
        }
        
        return res.size();
    }
}