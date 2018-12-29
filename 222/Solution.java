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
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        int ll = l(root.left);
        int rl = l(root.right);
        if(ll == rl) return (1 << ll) + countNodes(root.right);
        return (1 << (ll - 1)) + countNodes(root.left);
    }
    
    private int l(TreeNode root){
        if(root == null)
            return 0;
        return 1 + l(root.left);
    }
    
    private int r(TreeNode root){
        if(root == null)
            return 0;
        return 1 + r(root.right);
    }
    
}