class MyHashMap {
    static final int BUCKET_SIZE = 1000;
    List<Node>[] buckets;
    /** Initialize your data structure here. */
    public MyHashMap() {
        buckets = new List[BUCKET_SIZE];
        for(int i = 0; i < BUCKET_SIZE; i++){
            buckets[i] = new LinkedList<Node>();
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        Node n = getNode(buckets[key % BUCKET_SIZE], key);
        if(n != null){
            n.val = value;
        } else {
            n = new Node(key, value);
            buckets[key % BUCKET_SIZE].add(n);
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int ret = -1;
        Node n = getNode(buckets[key % BUCKET_SIZE], key);
        if(n != null){
            ret = n.val;
        }
        return ret;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        Node n = getNode(buckets[key % BUCKET_SIZE], key);
        if(n != null){
            buckets[key % BUCKET_SIZE].remove(n);
        }
    }
    
    private boolean contains(List<Node> l, int key){
        for(Node n: l){
            if(n.key == key){
                return true;
            }
        }
        return false;
    }
    
    private Node getNode(List<Node> l, int key){
        for(Node n: l){
            if(n.key == key){
                return n; // subject to change to for loop if it is not working.
            }
        }
        return null;
    }
    
    class Node{
        int key;
        int val;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }    
    }
}



/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
 