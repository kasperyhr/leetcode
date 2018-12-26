class Solution {
    public void wallsAndGates(int[][] rooms) {
        LinkedList<int[]> l1 = new LinkedList<int[]>();
        LinkedList<int[]> l2 = new LinkedList<int[]>();
        int val = 0;
        int M = rooms.length;
        if(M == 0)
            return;
        int N = rooms[0].length;
        if(N == 0)
            return;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(rooms[i][j] == val){
                    l2.addLast(new int[]{i, j - 1});
                    l2.addLast(new int[]{i, j + 1});
                    l2.addLast(new int[]{i - 1, j});
                    l2.addLast(new int[]{i + 1, j});
                }
            }
        }
        while(!l2.isEmpty()){
            l1 = l2;
            val++;
            l2 = new LinkedList<int[]>();
            while(!l1.isEmpty()){
                int[] a = l1.removeFirst();
                if(a[0] < 0 || a[0] >= M)
                    continue;
                if(a[1] < 0 || a[1] >= N)
                    continue;
                if(rooms[a[0]][a[1]] <= val)
                    continue;
                rooms[a[0]][a[1]] = val;
                l2.addLast(new int[]{a[0], a[1] - 1});
                l2.addLast(new int[]{a[0], a[1] + 1});
                l2.addLast(new int[]{a[0] - 1, a[1]});
                l2.addLast(new int[]{a[0] + 1, a[1]});
            }
        }
    }
}