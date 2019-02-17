class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        for(char c: s.toCharArray()){
            m.put(c, m.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> q = new PriorityQueue<Map.Entry<Character, Integer>>((a, b) -> b.getValue() - a.getValue());
        q.addAll(m.entrySet());
        
        StringBuffer sb = new StringBuffer();
        while(!q.isEmpty()){
            Map.Entry<Character, Integer> e = q.poll();
            for(int i = 0; i < e.getValue(); i++){
                sb.append(e.getKey());
            }
        }
        return sb.toString();
    }
}