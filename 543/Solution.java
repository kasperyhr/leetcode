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
    int len = 1;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return len - 1;
    }
    
    private int depth(TreeNode root){
        if(root == null)
            return 0;
    
        int left = depth(root.left);
        int right = depth(root.right);
        len = Math.max(len, left + right + 1);
        return Math.max(left, right) + 1;
    }
}