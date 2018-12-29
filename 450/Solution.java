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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return root;
        if(key < root.val)
            root.left = deleteNode(root.left, key);
        else if(key > root.val)
            root.right = deleteNode(root.right, key);
        else{
            if(root.left == null){
                root = root.right;
            } else if(root.right == null){
                root = root.left;
            } else {
                int v = l(root.right);
                root.right = deleteNode(root.right, v);
                root.val = v;
            }
        }
        return root;
    }
    
    private int l(TreeNode root){
        if(root.left != null)
            return l(root.left);
        return root.val;
    }
}