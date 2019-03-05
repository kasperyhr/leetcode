class Solution {
    public boolean lemonadeChange(int[] bills) {
        int f = 0;
        int t = 0;
        for(int num: bills){
            if(num == 5) f++;
            if(num == 10){
                if(f == 0) return false;
                f--;
                t++;
            }
            if(num == 20){
                if(f == 0) return false;
                if(t == 0){
                    if(f < 3) return false;
                    f -= 3;
                } else {
                    t -= 1;
                    f -= 1;
                }
            }
        }
        return true;
    }
}