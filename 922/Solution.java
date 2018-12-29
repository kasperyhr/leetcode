class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int odd = 1;
        int even = 0;
        while(odd < A.length && even < A.length){
            while(odd < A.length && A[odd] % 2 != 0) odd += 2;
            while(even < A.length && A[even] % 2 == 0) even += 2;
            if(odd < A.length){
                int tmp = A[odd];
                A[odd] = A[even];
                A[even] = tmp;
            }
        }
        return A;
    }
}