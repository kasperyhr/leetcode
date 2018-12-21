class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        // We will run the Dijkstra algorithm.
        // First we need to create the init value and asign them to Integer.MAX_VALUE.
        int[] time = new int[N];
        for(int i = 0; i < N; i++){
            time[i] = Integer.MAX_VALUE;
        }
        time[K - 1] = 0;
        Map<Integer, List<int[]>> m = new HashMap<Integer, List<int[]>>();
        for(int i = 0; i < times.length; i++){
            List<int[]> l = m.getOrDefault(times[i][0] - 1, new ArrayList<int[]>());
            int[] arr = new int[]{times[i][1] - 1, times[i][2]};
            l.add(arr);
            m.put(times[i][0] - 1, l);
        }
        int cnt = 0;
        boolean[] bool = new boolean[N];
        while(cnt < N){
            int max = Integer.MAX_VALUE;
            int maxIdx = 0;
            for(int i = 0; i < N; i++){
                if(!bool[i] && max > time[i]){
                    max = time[i];
                    maxIdx = i;
                }
            }
            bool[maxIdx] = true;
            List<int[]> l = m.get(maxIdx);
            if(l != null)
                for(int[] a: l){
                    time[a[0]] = Math.min(time[a[0]], a[1] + time[maxIdx]);
                }
            cnt++;
        }
        int currMax = -1;
        for(int i = 0; i < N; i++){
            if(currMax < time[i])
                currMax = time[i];
        }
        if(currMax == Integer.MAX_VALUE)
            currMax = -1;
        return currMax;
    }
    private void p(int[] a){
        for(int i: a)
            System.out.print(i + " ");
        System.out.println();
    }
}