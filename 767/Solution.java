class Solution {
    public String reorganizeString(String S) {
        int N = S.length();
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        for(char c: S.toCharArray()){
            m.put(c, m.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> q = new PriorityQueue<Map.Entry<Character, Integer>>((a, b) -> b.getValue() - a.getValue());
        q.addAll(m.entrySet());
        if(q.peek().getValue() > (N + 1) / 2) return "";
        StringBuilder ret = new StringBuilder();
        while(q.size() >= 2){
            Map.Entry<Character, Integer> e1 = q.poll();
            Map.Entry<Character, Integer> e2 = q.poll();
            ret.append(e1.getKey());
            ret.append(e2.getKey());
            e1.setValue(e1.getValue() - 1);
            e2.setValue(e2.getValue() - 1);
            if(e1.getValue() > 0) q.offer(e1);
            if(e2.getValue() > 0) q.offer(e2);
        }
        if(q.size() > 0) ret.append(q.poll().getKey());
        return ret.toString();
    }
}