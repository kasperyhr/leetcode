class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0|| matrix[0].length == 0)
            return false;
        return search(matrix, target, 0, 0, matrix.length, matrix[0].length);
    }
    
    private boolean search(int[][] matrix, int target, int startI, int startJ, int endI, int endJ){
        if(matrix[startI][startJ] == target)
            return true;
        if(matrix[startI][startJ] > target)
            return false;
        if(matrix[endI - 1][endJ - 1] < target)
            return false;
        if(startI + 1 == endI && startJ + 1 == endJ)
            return false;
        int midI = (startI + endI) / 2;
        int midJ = (startJ + endJ) / 2;
        if(startI + 1 == endI)
            return search(matrix, target, startI, startJ, endI, midJ) 
            || search(matrix, target, startI, midJ, endI, endJ);
        if(startJ + 1 == endJ)
            return search(matrix, target, startI, startJ, midI, endJ)
            || search(matrix, target, midI, startJ, endI, endJ);
        return search(matrix, target, startI, startJ, midI, midJ)
            || search(matrix, target, startI, midJ, midI, endJ)
            || search(matrix, target, midI, startJ, endI, midJ)
            || search(matrix, target, midI, midJ, endI, endJ);
        
    }
}