// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    List<Integer> l;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    l = new LinkedList<Integer>();
        while(iterator.hasNext()){
            l.add(iterator.next());
        }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(hasNext())
            return l.get(0);
        return 0;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    return l.remove(0);
	}

	@Override
	public boolean hasNext() {
	    return l.size() > 0;
	}
}