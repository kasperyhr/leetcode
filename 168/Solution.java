class Solution {
    public String convertToTitle(int n) {
        String s = "";
        while( n > 0 ){
            s = (char)( ((n % 26) == 0 ? 26 : n % 26) + 'A' - 1) + s;
            if(n % 26 == 0)
                n -= 26;
            n /= 26;
        }
        return s;
    }
}