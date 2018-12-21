class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num == 1)
            return false;
        int ret = 1;
        for(int i = 2; i * i <= num; i++){
            if(num % i == 0){
                ret += i;
                if(ret != i * i)
                    ret += num / i;
            }
        }
        return ret == num;
    }
}