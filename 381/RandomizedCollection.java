class RandomizedCollection {
    Map<Integer, Set<Integer>> m;
    ArrayList<Integer> l;
    Random r;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        m = new HashMap<Integer, Set<Integer>>();
        l = new ArrayList<Integer>();
        r = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        // System.out.println("INS " + val);
        boolean ret = !m.containsKey(val);
        l.add(val);
        Set<Integer> ll = m.getOrDefault(val, new HashSet<Integer>());
        ll.add(l.size() - 1);
        m.put(val, ll);
        // p();
        return ret;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        // System.out.println("DEL " + val);
        if(!m.containsKey(val))
            return false;
        Set<Integer> ll = m.get(val);
        int pos = ll.iterator().next();
        if(val != l.get(l.size() - 1)){
            int val1 = l.get(l.size() - 1);
            l.set(pos, val1);
            Set<Integer> ll1 = m.get(val1);
            ll1.remove(l.size() - 1);
            ll1.add(pos);
            m.put(val1, ll1);
            ll.add(l.size() - 1);
            ll.remove(pos);
        }
        ll.remove(l.size() - 1);
        l.remove(l.size() - 1);
        m.put(val, ll);
        if(ll.isEmpty())
            m.remove(val);
        // p();
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return l.get(r.nextInt(l.size()));
    }
    
    private void p(){
        System.out.println("------");
        System.out.println("STATUS");
        for(int i: l){
            System.out.print(i + " ");
        }
        System.out.println();
        for(int key: m.keySet()){
            System.out.print("key: " + key + " , pos: ");
            for(int pos: m.get(key)){
                System.out.print(pos + " ");
            }
            System.out.println();
        }
        System.out.println("------");
        
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */