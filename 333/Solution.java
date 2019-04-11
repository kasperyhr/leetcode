/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    class Result{
        int largestSize;
        boolean isBST;
        Integer largestVal;
        Integer smallestVal;
        Result left;
        Result right;
        
        Result(){
            isBST = true;
            largestSize = 0;
            largestVal = null;
            smallestVal = null;
        }
        
        Result(TreeNode root){
            if(root.left != null){
                left = new Result(root.left);
            } else {
                left = new Result();
            }
            
            if(root.right != null){
                right = new Result(root.right);
            } else {
                right = new Result();
            }
            
            isBST = false;
            if(left.isBST && right.isBST){
                if((left.largestVal == null || left.largestVal < root.val) &&
                   (right.smallestVal == null || right.smallestVal > root.val)){
                    isBST = true;
                }
            }
            
            if(isBST){
                largestSize = left.largestSize + right.largestSize + 1;
                largestVal = right.largestVal;
                if(largestVal == null){
                    largestVal = root.val;
                }
                smallestVal = left.smallestVal;
                if(smallestVal == null){
                    smallestVal = root.val;
                }
            } else {
                largestSize = Math.max(left.largestSize, right.largestSize);
            }
        }
    }
    
    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;
        Result r = new Result(root);
        return r.largestSize;
    }
}