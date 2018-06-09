class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return new ArrayList<Integer>();
        return spiralOrder(matrix, 0);
    }
    
    public static List<Integer> spiralOrder(int[][] matrix, int wall) {
        return right(matrix, 0);
    }
    
    public static List<Integer> right(int[][] matrix, int wall) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(matrix[0].length <= wall * 2)
            return ret;
        for(int i = wall; i < matrix[0].length - wall; i++){
            ret.add(matrix[wall][i]);
        }
        ret.addAll(down(matrix, wall));
        return ret;
    }
    
    public static List<Integer> down(int[][] matrix, int wall) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(matrix.length <= wall * 2 + 1)
            return ret;
        for(int i = wall + 1; i < matrix.length - wall; i++){
            ret.add(matrix[i][matrix[0].length - 1 - wall]);
        }
        ret.addAll(left(matrix, wall));
        return ret;
    }
    
    public static List<Integer> left(int[][] matrix, int wall) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(matrix[0].length <= wall * 2 + 1)
            return ret;
        for(int i = matrix[0].length - 2 - wall; i >= wall ; i--){
            ret.add(matrix[matrix.length - 1 - wall][i]);
        }
        ret.addAll(up(matrix, wall));
        return ret;
    }
    
    public static List<Integer> up(int[][] matrix, int wall) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(matrix.length <= wall * 2 + 2)
            return ret;
        for(int i = matrix.length - 2 - wall; i > wall; i--){
            ret.add(matrix[i][wall]);
        }
        ret.addAll(right(matrix, wall + 1));
        return ret;
    }
}