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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1){
            TreeNode n = new TreeNode(v);
            n.left = root;
            return n;
        }
        if(root == null)
            return null;
        if(d == 2){
            TreeNode l = root.left;
            root.left = new TreeNode(v);
            root.left.left = l;
            
            TreeNode r = root.right;
            root.right = new TreeNode(v);
            root.right.right = r;
            return root;
        }
        root.left = addOneRow(root.left, v, d - 1);
        root.right = addOneRow(root.right, v, d - 1);
        return root;
    }
}