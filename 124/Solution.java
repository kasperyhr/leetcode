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
    public int maxPathSum(TreeNode root) {
        if(root == null)
            return Integer.MIN_VALUE;
        if(root.left == null && root.right == null)
            return root.val;
        if(root.left == null)
            return Math.max(maxPathSum(root.right), maxSum(root.right) + root.val);
        if(root.right == null)
            return Math.max(maxPathSum(root.left), maxSum(root.left) + root.val);
        return Math.max(Math.max(maxPathSum(root.left), maxPathSum(root.right)), maxSum(root.left) + maxSum(root.right) + root.val);
    }
    
    private int maxSum(TreeNode root){
        if(root == null)
            return 0;
        return Math.max(Math.max(maxSum(root.left), maxSum(root.right)) + root.val, 0);
    }
}