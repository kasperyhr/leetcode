class Solution {
    public int shortestDistance(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int[][] ret = new int[M][N];
        Set<int[]> s = new HashSet<int[]>();
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(grid[i][j] == 1)
                    s.add(new int[]{i, j});
            }
        }
        for(int[] ss: s){
            int[][] l = new int[M][N];
            for(int i = 0; i < M; i++){
                for(int j = 0; j < N; j++){
                    l[i][j] = Integer.MAX_VALUE;
                }
            }
            int val = 0;
            l[ss[0]][ss[1]] = val;
            LinkedList<int[]> l1 = new LinkedList<int[]>();
            LinkedList<int[]> l2 = new LinkedList<int[]>();
            l2.addLast(new int[]{ss[0], ss[1] - 1});
            l2.addLast(new int[]{ss[0], ss[1] + 1});
            l2.addLast(new int[]{ss[0] - 1, ss[1]});
            l2.addLast(new int[]{ss[0] + 1, ss[1]});
            while(!l2.isEmpty()){
                l1 = l2;
                l2 = new LinkedList<int[]>();
                val++;
                while(!l1.isEmpty()){
                    int[] arr = l1.removeFirst();
                    if(arr[0] < 0 || arr[0] >= M)
                        continue;
                    if(arr[1] < 0 || arr[1] >= N)
                        continue;
                    if(grid[arr[0]][arr[1]] > 0)
                        continue;
                    if(l[arr[0]][arr[1]] <= val)
                        continue;
                    l[arr[0]][arr[1]] = val;
                    l2.addLast(new int[]{arr[0], arr[1] - 1});
                    l2.addLast(new int[]{arr[0], arr[1] + 1});
                    l2.addLast(new int[]{arr[0] - 1, arr[1]});
                    l2.addLast(new int[]{arr[0] + 1, arr[1]});
                }
            }
            for(int i = 0; i < M; i++){
                for(int j = 0; j < N; j++){
                    if(ret[i][j] != Integer.MAX_VALUE && l[i][j] != Integer.MAX_VALUE && l[i][j] != 0)
                        ret[i][j] += l[i][j];
                    else
                        ret[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                min = Math.min(min, ret[i][j]);
            }
        }
        if(min == Integer.MAX_VALUE)
            min = -1;
        return min;
    }
}