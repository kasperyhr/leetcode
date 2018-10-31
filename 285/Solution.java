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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null)
            return null;
        TreeNode ret = inorderSuccessor(root.left, p);
        if(ret != null)
            return ret;
        if(root.val > p.val)
            return root;
        return inorderSuccessor(root.right, p);
    }
}