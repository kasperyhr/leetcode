class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int L = flowerbed.length;
        if(n <= 0)
            return true;
        if(L == 1){
            if(flowerbed[0] == 0 && n <= 1) return true;
            else return false;
        }
        
        if(L > 1){
            if(flowerbed[0] == 0 && flowerbed[1] == 0){
                flowerbed[0] = 1;
                n--;
            }
            if(flowerbed[L - 1] == 0 && flowerbed[L - 2] == 0){
                flowerbed[L - 1] = 1;
                n--;
            }
        }
        if(n <= 0)
            return true;
        for(int i = 1; i < L - 1; i++){
            if(flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0){
                flowerbed[i] = 1;
                n--;
                if(n <= 0)
                    return true;
            }
        }
        return false;
    }
}