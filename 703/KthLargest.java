class KthLargest {
    PriorityQueue<Integer> heap;
    int k;
    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<Integer>(k);
        this.k = k;
        for(int num: nums){
            heap.add(num);
            if(heap.size() > k) heap.poll();
        }
        System.out.println(heap.size());
    }
    
    public int add(int val) {
        if(heap.size() < k) heap.offer(val);
        else if(heap.peek() < val){
            heap.poll();
            heap.offer(val);
        }
        return heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */