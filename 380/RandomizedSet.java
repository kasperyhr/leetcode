class RandomizedSet {
    Map<Integer, Integer> m;
    ArrayList<Integer> l;
    Random r;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        m = new HashMap<Integer, Integer>();
        l = new ArrayList<Integer>();
        r = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(m.containsKey(val))
            return false;
        l.add(val);
        m.put(val, l.size() - 1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!m.containsKey(val))
            return false;
        int pos = m.get(val);
        if(pos < l.size() - 1){
            int val1 = l.get(l.size() - 1);
            l.set(pos, val1);
            m.put(val1, pos);
        }
        l.remove(l.size() - 1);
        m.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return l.get(r.nextInt(l.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */