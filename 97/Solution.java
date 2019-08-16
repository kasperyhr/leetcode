class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
            return false;
        boolean[][] matrix = new boolean[s1.length() + 1][s2.length() + 1];
        matrix[0][0] = true;
        for(int i = 0; i < s1.length(); i++){
            matrix[i + 1][0] = matrix[i][0] && s1.charAt(i) == s3.charAt(i);
        }
        for(int i = 0; i < s2.length(); i++){
            matrix[0][i + 1] = matrix[0][i] && s2.charAt(i) == s3.charAt(i);
        }
        
        for(int i = 0; i < s1.length(); i++){
            for(int j = 0; j < s2.length(); j++){
                matrix[i + 1][j + 1] |= matrix[i][j + 1] && s1.charAt(i) == s3.charAt(i + j + 1);
                matrix[i + 1][j + 1] |= matrix[i + 1][j] && s2.charAt(j) == s3.charAt(i + j + 1);
            }
        }
        return matrix[s1.length()][s2.length()];
    }
}