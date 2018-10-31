public class ZigzagIterator {
    List<Integer> ls;
    int ptr;
    int size;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        ls = new LinkedList<Integer>();
        ptr = size = 0;
        int cursor = 0;
        while(cursor < v1.size() || cursor < v2.size()){
            if(cursor < v1.size()){
                ls.add(v1.get(cursor));
                size++;
            }
            if(cursor < v2.size()){
                ls.add(v2.get(cursor));
                size++;
            }
            cursor++;
        }
    }

    public int next() {
        return ls.get(ptr++);
    }

    public boolean hasNext() {
        return ptr < size;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */