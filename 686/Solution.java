class Solution {
    public int repeatedStringMatch(String A, String B) {
        int q = 1;
        StringBuilder sb = new StringBuilder(A);
        for(; sb.length() < B.length();q++) sb.append(A);
        if(sb.indexOf(B) >= 0) return q;
        else if(sb.append(A).indexOf(B) >= 0) return q+1;
        else return -1;
    }
}