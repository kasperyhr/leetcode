class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int low = 1;
        int high = -1;
        for(int p: piles)
            if(p > high)
                high = p;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(poss(piles, H, mid))
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
    
    private boolean poss(int[] piles, int H, int val){
        int cnt = 0;
        for(int p: piles)
            cnt += (int)(Math.ceil(p * 1.0 / val));
        if(cnt > H)
            return false;
        return true;
    }
}