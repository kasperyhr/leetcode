/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    List<Integer> l;
    public NestedIterator(List<NestedInteger> nestedList) {
        l = new LinkedList<Integer>(); 
        push(nestedList);        
    }

    @Override
    public Integer next() {
        return l.remove(0);
    }

    @Override
    public boolean hasNext() {
        return l.size() > 0;
    }
    
    private void push(List<NestedInteger> ls){
        for(NestedInteger ni: ls){
            if(ni.isInteger())
                l.add(ni.getInteger());
            else
                push(ni.getList());
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */