class Solution {
    public int numSquares(int n) {
        int[] num = new int[n + 1];
        for(int i = 1; i <= n; i++){
            double a = Math.sqrt(i);
            if(a == Math.floor(a)){
                num[i] = 1;
                continue;
            }
                
            num[i] = Integer.MAX_VALUE;
            for(int j = 1; j * j < i; j++){
                num[i] = Math.min(num[i - j * j] + 1, num[i]);
            }
        }
        return num[n];
    }
}