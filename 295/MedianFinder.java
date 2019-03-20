class MedianFinder {
    PriorityQueue<Integer> min_heap;
    PriorityQueue<Integer> max_heap;
    /** initialize your data structure here. */
    public MedianFinder() {
        min_heap = new PriorityQueue(Collections.reverseOrder());
        max_heap = new PriorityQueue();
    }
    
    public void addNum(int num) {
        if(min_heap.isEmpty() || min_heap.peek() >= num){
            min_heap.add(num);
        } else {
            max_heap.add(num);
        }
        balance();
    }
    
    public double findMedian() {
        if(min_heap.size() == 0) return 0.0;
        if(min_heap.size() == max_heap.size()) return (min_heap.peek() + max_heap.peek()) / 2.0;
        return (double)min_heap.peek();
    }
    
    private void balance(){
        while(min_heap.size() > max_heap.size() + 1){
            max_heap.add(min_heap.poll());
        }
        while(min_heap.size() < max_heap.size()){
            min_heap.add(max_heap.poll());
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */