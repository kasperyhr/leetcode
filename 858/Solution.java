class Solution {
    public int mirrorReflection(int p, int q) {
        if(q == 0)
            return 0;
        if(p == q)
            return 1;
        int g = gcd(p, q);
        p = p / g;
        q = q / g;
        if(q % 2 == 0)
            return 0;
        if(p % 2 == 0)
            return 2;
        return 1;
    }
    
    private int gcd(int p, int q){
        if(q == 0)
            return p;
        return gcd(q, p % q);
    }
}