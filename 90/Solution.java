class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        TreeMap<Integer, Integer> m = new TreeMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++)
            m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> l = new ArrayList<Integer>();
        bt(m, m.firstKey(), l, ret);
        return ret;
    }
    
    private List<Integer> bt(TreeMap<Integer, Integer> m, Integer key, List<Integer> l, List<List<Integer>> ret){
        if(key == null)
            ret.add(new ArrayList<Integer>(l));
        else{
            int val = m.get(key);
            Integer nkey = m.higherKey(key);
            for(int i = 0; i < val; i++){
                l = bt(m, nkey, l, ret);
                l.add(key);
            }
            l = bt(m, nkey, l, ret);
            l = l.subList(0, l.size() - val);
        }
        return l;
    }
    
}