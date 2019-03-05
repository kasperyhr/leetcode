class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;
        Set<Integer> setB = new HashSet<Integer>();
        
        for(int num: A){
            sumA += num;
        }
        for(int num: B){
            setB.add(num);
            sumB += num;
        }
        
        for(int num: A){
            if(setB.contains((sumB - sumA) / 2 + num)){
                return new int[]{num, (sumB - sumA) / 2 + num};
            }
        }
        return new int[2];
    }
}