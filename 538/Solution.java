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
    public TreeNode convertBST(TreeNode root) {
        traverse(root, 0);
        return root;
    }
    
    private int traverse(TreeNode root, int val){
        if(root == null)
            return val;
        int v1 = traverse(root.right, val);
        root.val = root.val + v1;
        int v2 = root.val;
        int v3 = traverse(root.left, v2);
        return v3;
    }
}