class Solution {
    public int preimageSizeFZF(int K) {
        K = K + 1;
        int Z = 6;
        while(K > Z)
            Z = Z * 5 + 1;
        while(Z != 1){
            K = K % Z;
            if(K == 0)
                return 0;
            Z = (Z - 1) / 5;
        }
        return 5;
    }
}