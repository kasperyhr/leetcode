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
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        if(Math.abs(depth(root.left) - depth(root.right)) < 2){
            return isBalanced(root.left) && isBalanced(root.right);
        } else
            return false;
    }
    
    public static int depth(TreeNode root){
        if(root == null)
            return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}