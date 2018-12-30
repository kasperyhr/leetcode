class Solution {
    public boolean isReflected(int[][] points) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Set<String> s = new HashSet<String>();
        for(int i = 0; i < points.length; i++){
            max = Math.max(max, points[i][0]);
            min = Math.min(min, points[i][0]);
            s.add(points[i][0] + "-" + points[i][1]);
        }
        int mid = max + min;
        for(int i = 0; i < points.length; i++) if(!s.contains((mid - points[i][0]) + "-" + points[i][1])) return false;
        return true;      
    }
}