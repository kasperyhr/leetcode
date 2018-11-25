class Solution {
    public int minIncrementForUnique(int[] A) {
        if(A.length < 2)
            return 0;
        int ret = 0;
        Arrays.sort(A);
        HashSet<Integer> s = new HashSet<Integer>();
        int max = A[0];
        for(int i = 0; i < A.length; i++){
            if(!s.contains(A[i])){
                s.add(A[i]);
                max = A[i];
            } else {
                int num = max + 1;
                // System.out.println(num + " " + A[i]);
                ret += num - A[i];
                s.add(num);
                max += 1;
            }
        } 
        return ret;
    }
}
