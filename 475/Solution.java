class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int l = 0;
        int r = Math.max(houses[houses.length - 1], heaters[heaters.length - 1]);
        while(l + 1 < r){
            int m = l + (r - l) / 2;
            if(canWarm(houses, heaters, m))
                r = m;
            else
                l = m;
        }
        if(canWarm(houses, heaters, l)) return l;
        return r;
    }
    
    private boolean canWarm(int[] houses, int[] heaters, int r){
        int ptr1 = 0;
        int ptr2 = 0;
        while(ptr1 < houses.length){
            if(ptr2 == heaters.length) return false;
            if(Math.abs(heaters[ptr2] - houses[ptr1]) <= r) ptr1++;
            else ptr2++;
        }
        return true;
    }
}