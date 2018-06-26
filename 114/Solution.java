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
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        if(root.left == null){
            flatten(root.right);
            return;
        }
        if(root.right == null){
            root.right = root.left;
            root.left = null;
            flatten(root.right);
            return;
        }
        
        TreeNode leaf = root.left;
        while(leaf.right != null)
            leaf = leaf.right;
        leaf.right = root.right;
        root.right = root.left;
        root.left = null;
        flatten(root.right);
    }
}