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
    public int longestUnivaluePath(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right)), length(root.left, root.val) + length(root.right, root.val));
    }
    
    private int length(TreeNode root, int val){
        if(root == null)
            return 0;
        if(root.val != val)
            return 0;
        return 1 + Math.max(length(root.left, val), length(root.right, val));
    }
}