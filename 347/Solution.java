class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for(int num: nums){
            m.put(num, m.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<Map.Entry<Integer, Integer>>((a, b) -> b.getValue() - a.getValue());
        q.addAll(m.entrySet());
        
        List<Integer> ret = new ArrayList<Integer>();
        for(int i = 0; i < k; i++){
            ret.add(q.poll().getKey());
        }
        return ret;
    }
}