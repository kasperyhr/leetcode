class Solution {
    public double largestTriangleArea(int[][] points) {
        int ret = 0;
        for(int i = 0; i < points.length; i++)
            for(int j = i + 1; j < points.length; j++)
                for(int k = j + 1; k < points.length; k++)
                    ret = Math.max(ret, Area2(points[i], points[j], points[k]));
        return (double) ret / 2;
    }
    
    private int Area2(int[] p, int[] q, int[] r){
        return Math.abs(((p[0] - q[0]) * (p[1] - r[1])) - ((p[1] - q[1]) * (p[0] - r[0])));
    }
}