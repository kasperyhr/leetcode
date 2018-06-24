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
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return symmetric(root.left, root.right);
    }
    
    private boolean symmetric(TreeNode l, TreeNode r){
        if(l == null && r == null)
            return true;
        if(l == null || r == null)
            return false;
        
        if(l.val == r.val){
            return symmetric(l.left, r.right) && symmetric(l.right, r.left);
        } else 
            return false;
    }
}