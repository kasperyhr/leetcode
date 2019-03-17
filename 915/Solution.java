class Solution {
    public int partitionDisjoint(int[] A) {
        int N = A.length;
        int[] left = new int[N];
        int[] right = new int[N];
        left[0] = A[0];
        for(int i = 1; i < N; i++){
            left[i] = Math.max(left[i - 1], A[i]);
        }
        right[N - 1] = A[N - 1];
        for(int i = N - 2; i >= 0; i--){
            right[i] = Math.min(right[i + 1], A[i]);
        }
        for(int i = 1; i < N; i++){
            if(left[i - 1] <= right[i]) return i;
        }
        return 0;
    }
}