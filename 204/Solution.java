class Solution {
    public int countPrimes(int n) {
        boolean[] b = new boolean[n];
        int ret = 0;
        for(int i = 2; i < n; i++){
            if(!b[i]){
                ret++;
                for(int j = 2; j * i < n; j++){
                    b[i * j] = true;
                }
            }
        }
        return ret;
    }
}