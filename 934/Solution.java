class Solution {
    public int shortestBridge(int[][] A) {
        int M = A.length;
        int N = A[0].length;
        List<Point> l1 = new LinkedList<Point>();
        List<Point> l2 = new LinkedList<Point>();
        boolean flag = false;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(A[i][j] == 1){
                    dfs(A, i, j, M, N, l1, l2, flag);
                    flag = !flag;
                }
            }
        }
        int maxDist = Integer.MAX_VALUE;
        for(Point p1: l1){
            for(Point p2: l2){
                maxDist = Math.min(maxDist, p1.dist(p2));
            }
        }
        return maxDist - 1;
    }
    
    private void dfs(int[][] A, int i, int j, int M, int N, List<Point> l1, List<Point> l2, boolean flag){
        if(i < 0 || i >= M)
            return;
        if(j < 0 || j >= N)
            return;
        if(A[i][j] == 0)
            return;
        A[i][j] = 0;
        if(flag)
            l1.add(new Point(i, j));
        else
            l2.add(new Point(i, j));
        dfs(A, i + 1, j, M, N, l1, l2, flag);
        dfs(A, i - 1, j, M, N, l1, l2, flag);
        dfs(A, i, j + 1, M, N, l1, l2, flag);
        dfs(A, i, j - 1, M, N, l1, l2, flag);
        
    }
    class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        int dist(Point p){
            return Math.abs(x - p.x) + Math.abs(y - p.y);
        }
    }
}