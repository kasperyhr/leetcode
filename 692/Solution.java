class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> m = new HashMap<String, Integer>();
        for(String s: words) m.put(s, m.getOrDefault(s, 0) + 1);
        PriorityQueue<Map.Entry<String, Integer>> q = new PriorityQueue<Map.Entry<String, Integer>>((a, b) -> b.getValue() - a.getValue() == 0 ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
        q.addAll(m.entrySet());
        List<String> ret = new ArrayList<String>();
        while(ret.size() < k){
            ret.add(q.poll().getKey());
        }
        return ret;
    }
}