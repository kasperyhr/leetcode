class Solution {
    public int findPairs(int[] nums, int k) {
        int ret = 0;
        if(k < 0) return ret;
        if(k == 0){
            Map<Integer, Integer> m = new HashMap();
            for(int num: nums){
                m.put(num, m.getOrDefault(num, 0) + 1);
            }
            for(int num: m.keySet()){
                if(m.get(num) > 1) ret++;
            }
        } else {
            Set<Integer> s = new HashSet();
            for(int num: nums){
                s.add(num);
            }
            for(int num: s){
                if(s.contains(num + k)) ret++;
            }
        }
        return ret;
    }
}