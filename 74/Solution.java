class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return false;
        int low = 0;
        int high = matrix.length - 1;
        int mid = (low + high) / 2;
        while(low < high){
            if(matrix[mid][0] > target)
                high = mid - 1;
            else if(matrix[mid][matrix[0].length - 1] < target)
                low = mid + 1;
            else
                break;
            mid = (low + high) / 2;
        }
        if(low == high){
            if(matrix[low][0] > target || matrix[low][matrix[0].length - 1] < target)
                return false;
            else
                mid = low;
        }
        int low2 = 0;
        int high2 = matrix[0].length - 1;
        int mid2 = (low2 + high2) / 2;
        while(low2 < high2){
            if(matrix[mid][mid2] > target)
                high2 = mid2 - 1;
            else if(matrix[mid][mid2] < target)
                low2 = mid2 + 1;
            else
                break;
            mid2 = (low2 + high2) / 2;
        }
        if(matrix[mid][mid2] == target)
            return true;
        return false;
        
    }
}