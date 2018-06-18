class Solution {
    public int maxRotateFunction(int[] A) {
        int sum = 0;
        int f = 0;
        for(int i = 0; i < A.length; i++){
            sum += A[i];
            f += i * A[i];
        }
        
        int curr = f;
        for(int i = A.length - 1; i > 0; i--){
            curr += sum - A.length * A[i];
            f = Math.max(f, curr);
        }
        return f;
    }
}