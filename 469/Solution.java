class Solution {
    private static final int X = 0;
    private static final int Y = 1;
    
    public boolean isConvex(List<List<Integer>> points) {
        int isLeft = 0;
        for(int i = 0; i < points.size(); i++){
            int j = (i+1)%points.size();
            int k = (i+2)%points.size();
            List<Integer> l1 = points.get(i);
            List<Integer> l2 = points.get(j);
            List<Integer> l3 = points.get(k);
            int l = (int) (Math.signum(Area2(l1, l2, l3)));
            if(Math.abs(l - isLeft) == 2){
                return false;
            }
            if(l != 0)
                isLeft = l;
        }
        return true;
    }
    private int Area2(List<Integer> a, List<Integer> b, List<Integer> c){
        return (b.get(X) - a.get(X)) * (c.get(Y) - a.get(Y))
              -(b.get(Y) - a.get(Y)) * (c.get(X) - a.get(X));
    }
}