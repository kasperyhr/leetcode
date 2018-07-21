/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int a = rand7();
        int b = rand7();
        if(a == 1 && b <= 4)
            return 1;
        if(a == 2 && b <= 4)
            return 2;
        if(a == 3 && b <= 4)
            return 3;
        if(a == 4 && b <= 4)
            return 4;
        if(a == 5 && b <= 4)
            return 5;
        if(a == 6 && b <= 4)
            return 6;
        if(a == 7 && b <= 4)
            return 7;
        if(a == 1 && b <= 6)
            return 8;
        if(a == 2 && b <= 6)
            return 8;
        if(a == 3 && b <= 6)
            return 9;
        if(a == 4 && b <= 6)
            return 9;
        if(a == 5 && b <= 6)
            return 10;
        if(a == 6 && b <= 6)
            return 10;
        return rand10();
    }
}