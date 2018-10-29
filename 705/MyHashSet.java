class MyHashSet {
    static final int BUCKET_SIZE = 1000;
    List<Node>[] buckets;
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = new List[BUCKET_SIZE];
        for(int i = 0; i < BUCKET_SIZE; i++){
            buckets[i] = new LinkedList<Node>();
        }
    }
    
    public void add(int key) {
        if(getNode(buckets[key % BUCKET_SIZE], key) == null)
            buckets[key % BUCKET_SIZE].add(new Node(key));
    }
    
    public void remove(int key) {
        Node n = getNode(buckets[key % BUCKET_SIZE], key);
        if(n != null){
            buckets[key % BUCKET_SIZE].remove(n);
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return getNode(buckets[key % BUCKET_SIZE], key) != null;
    }
    
    private Node getNode(List<Node> l, int data){
        for(Node n: l){
            if(n.data == data)
                return n;
        }
        return null;
    }
    
    class Node{
        int data;
        Node(int data){
            this.data = data;
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */