public class Vector2D implements Iterator<Integer> {
    
    List<Integer> l;
    public Vector2D(List<List<Integer>> vec2d) {
        l = new LinkedList<Integer>(); 
        for(List<Integer> vec: vec2d){
            for(int e: vec){
                l.add(e);
            }
        }
    }

    @Override
    public Integer next() {
        if(hasNext())
            return l.remove(0);
        return 0;
    }

    @Override
    public boolean hasNext() {
        return l.size() > 0;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */