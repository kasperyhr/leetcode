class Solution {
    public int totalFruit(int[] tree) {
        if(tree == null || tree.length == 0) return 0;
        int max_val = 0;
        Map<Integer, Integer> m = new HashMap();
        int j = 0;
        for(int i = 0; i < tree.length; i++){
            m.put(tree[i], m.getOrDefault(tree[i], 0) + 1);
            while(m.size() >= 3){
                m.put(tree[j], m.getOrDefault(tree[j], 0) - 1);
                if(m.get(tree[j]) == 0)
                    m.remove(tree[j]);
                j++;
            }
            max_val = Math.max(max_val, i - j + 1);
        }
        return max_val;
    }
}