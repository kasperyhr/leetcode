class RecentCounter {

    LinkedList<Integer> l;
    int ptr = 0;
    public RecentCounter() {
        l = new LinkedList<Integer>();
    }
    
    public int ping(int t) {
        l.add(t);
        while(l.get(ptr) + 3000 < t){
            ptr++;
        }
        return l.size() - ptr;
        
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
