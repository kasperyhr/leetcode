class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>((a, b) -> -(points[a][0] * points[a][0] + points[a][1] * points[a][1]) + (points[b][0] * points[b][0] + points[b][1] * points[b][1]) );
        for(int i = 0; i < points.length; i++){
            q.add(i);
            if(q.size() > K) q.remove();
        }
        int[][] ret = new int[K][2];
        for(int i = 0; i < K; i++){
            ret[i] = points[q.remove()];
        }
        return ret;
    }
}