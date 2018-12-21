class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ret = new ArrayList<Integer>();
        for(int i = left; i <= right; i++){
            if(div(i))
                ret.add(i);
        }
        return ret;
    }
    
    private boolean div(int i){
        int num = i;
        while(i > 0){
            int j = i % 10;
            if(j == 0 || num % j != 0) return false;
            i /= 10;
        }
        return true;
    }
}