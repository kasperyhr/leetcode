class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        int len = 0;
        for(List<Integer> l: wall){
            len = 0;
            for(int i: l){
                len += i;
                m.put(len, m.getOrDefault(len, 0) + 1);
            }
        }
        m.remove(len);
        int high = 0;
        for(int key: m.keySet()){
            high = Math.max(high, m.get(key));
        }
        return wall.size() - high;
    }
}