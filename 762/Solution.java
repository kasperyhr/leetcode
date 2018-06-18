class Solution {
    public int countPrimeSetBits(int L, int R) {
        Integer[] arr = {2, 3, 5, 7, 11, 13, 17, 19};
        List<Integer> prime = Arrays.asList(arr);
        int cnt = 0;
        for(int i = L; i <= R; i++){
            if(prime.contains(Integer.bitCount(i)))
                cnt += 1;
        }
        return cnt;
    }
}