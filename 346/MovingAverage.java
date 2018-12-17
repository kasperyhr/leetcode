class MovingAverage {
    List<Integer> l;
    int size;
    double sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        l = new LinkedList<Integer>();
        this.size = size;
        this.sum = 0.0;
    }
    
    public double next(int val) {
        l.add(val);
        sum += val;
        if(l.size() > size){
            int v = l.remove(0);
            sum -= v;
        }
        return sum / l.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */