class MinStack {
    Stack<Node> s;
    /** initialize your data structure here. */
    public MinStack() {
        s = new Stack();
    }
    
    public void push(int x) {
        Node n = new Node(x);
        int min = x;
        if(!s.isEmpty())
            min = Math.min(s.peek().min, min);
        n.min = min;
        s.push(n);
    }
    
    public void pop() {
        if(!s.isEmpty())
            s.pop();
    }
    
    public int top() {
        return s.peek().val;
    }
    
    public int getMin() {
        return s.peek().min;
    }
    
    class Node {
        int val;
        int min;
        Node(int v){
            val = v;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */