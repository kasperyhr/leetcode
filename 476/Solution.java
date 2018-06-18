class Solution {
    public int findComplement(int num) {
        int i = 0;
        for(i = 0; i < 31; i++){
            if(num < Math.pow(2, i))
                break;
        }
        int k = (int)Math.pow(2, i) - 1;
        if(i == 31)
            k = Integer.MAX_VALUE;
        return k ^ num;
    }
}