class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int min = -1;
        ArrayDeque<int[]> aq = new ArrayDeque();
        //  [src, K, currPrice]
        if(src == dst)
            return 0;
        for(int i = 0; i < flights.length; i++){
            if(flights[i][0] == src){
                int[] a = {flights[i][1], K - 1, flights[i][2]};
                aq.add(a);
                if(flights[i][1] == dst){
                    min = flights[i][2];
                }
            }
        }
        // p(aq);
        while(!aq.isEmpty()){
            int[] b = aq.removeFirst();
            if(b[1] == -1){
                continue;
            } else {
                for(int i = 0; i < flights.length; i++){
                    if(flights[i][0] == b[0]){
                        if(flights[i][1] == dst){
                            if(min == -1 || min > flights[i][2] + b[2]){
                                min = flights[i][2] + b[2];
                                //System.out.println(min + " " + K);
                            }
                        }
                        if(min > 0 && min > flights[i][2] + b[2] || min == -1){
                            int[] a = {flights[i][1], b[1] - 1, b[2] + flights[i][2]};
                            aq.add(a);
                        }
                    }
                }
            }
            // p(aq);
        }
        return min;
    }
    
    private void p(ArrayDeque<int[]> aq){
        for(int[] i: aq){
            System.out.print(i[0] + " " + i[1] + " " + i[2] + ", ");
        }
        System.out.println();
    }
}