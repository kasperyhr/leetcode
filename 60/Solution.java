class Solution {
    public String getPermutation(int n, int k) {
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = i + 1;
        }
        perm(arr, n, 0, k - 1);
        String ret = "";
        for(int i = 0; i < n; i++){
            ret += arr[i];
        }
        return ret;
    }
    
    private void perm(int[] arr, int n, int idx, int k){
        if(idx == n - 1)
            return;
        int f = fac(n - 1 - idx);
        int v = k / f;
        int tmp = arr[idx];
        arr[idx] = arr[v + idx];
        arr[v + idx] = tmp;
        Arrays.sort(arr, idx + 1, n);
        perm(arr, n, idx + 1, k % f);
    }
    
    private int fac(int i){
        if(i == 1)
            return 1;
        return i * fac(i - 1);
    }
}