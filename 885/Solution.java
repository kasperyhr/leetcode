class Solution {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] ret = new int[R * C][2];
        boolean d1 = false;
        boolean d2 = false;
        int n = 1;
        int v = 1;
        for(int i = 0; i < R * C; i++){
            while(!valid(R, C, r0, c0)){
                if(d1 && d2) r0--;
                else if(!d1 && d2) r0++;
                else if(d1 && !d2) c0--;
                else c0++;
                v--;
                if(v == 0){
                    if(d2){
                        d1 = !d1;
                        n++;
                    }
                    d2 = !d2;
                    v = n;
                }
            }
            ret[i][0] = r0;
            ret[i][1] = c0;
            if(d1 && d2) r0--;
            else if(!d1 && d2) r0++;
            else if(d1 && !d2) c0--;
            else c0++;
            v--;
            if(v == 0){
                if(d2){
                    d1 = !d1;
                    n++;
                }
                d2 = !d2;
                v = n;
            }
        }
        return ret;
    }
    
    private boolean valid(int R, int C, int r0, int c0){
        if(r0 < 0 || r0 >= R)
            return false;
        if(c0 < 0 || c0 >= C)
            return false;
        return true;
    }
}