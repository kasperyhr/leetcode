class Solution {
    public boolean rotateString(String A, String B) {
        if(A.length() != B.length()) return false;
        String C = B + B;
        if(C.indexOf(A) != -1) return true;
        return false;
    }
}