/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
    public List<Point> outerTrees(Point[] points) {
        if(points.length < 3)
            return new ArrayList(Arrays.asList(points));
        Point low = lowest(points);
        List<Point> sorted = sortByAngle(low, points);
        List<Point> ret = new ArrayList();
        ret.addAll(sorted.subList(0, 3));
        for(int i = 3; i < sorted.size(); i++){
            while(!leftOn(ret.get(ret.size() - 2), ret.get(ret.size() - 1), sorted.get(i)))
                ret.remove(ret.get(ret.size() -1));
            ret.add(sorted.get(i));
        }
        for(int i = sorted.size() - 2; i >= 0; i--){
            if(on(ret.get(0), ret.get(ret.size() - 1), sorted.get(i)) && !ret.contains(sorted.get(i)))
                ret.add(sorted.get(i));
            else
                break;
        }
        return ret;
    }
    
    private boolean leftOn(Point a, Point b, Point c){
        return (b.x - a.x) * (c.y - a.y) - (c.x - a.x) * (b.y - a.y) >= 0;
    }
    
    private boolean on(Point a, Point b, Point c){
        return (b.x - a.x) * (c.y - a.y) - (c.x - a.x) * (b.y - a.y) == 0;
    }
    
    private Point lowest(Point[] points){
        Point ret = points[0];
        for(int i = 1; i < points.length; i++){
            if(ret.y > points[i].y)
                ret = points[i];
            else if(ret.y == points[i].y && ret.x > points[i].x)
                ret = points[i];
        }
        return ret;
    }
    
    private List<Point> sortByAngle(Point low, Point[] points){
        List<Point> ret = new ArrayList(Arrays.asList(points));
        Collections.sort(ret, new Comparator<Point>() {
           @Override
            public int compare(Point a, Point b){
                if(a.x == low.x && a.y == low.y)
                    return -1;
                else if(b.x == low.x && b.y == low.y)
                    return 1;
                int val = crossProduct(low, a, low, b);
                if(val != 0)
                    return -val;
                if(a.x == b.x && a.y == b.y)
                    return 0;
                if(Math.abs(a.x - low.x) <= Math.abs(b.x - low.x) && Math.abs(a.y - low.y) <= Math.abs(b.y - low.y))
                    return -1;
                else
                    return 1;
            }
        });
        return ret;
    }
    
    private int crossProduct(Point a, Point b, Point c, Point d){
        return (b.x - a.x) * (d.y - c.y) - (d.x - c.x) * (b.y - a.y);
    }
}