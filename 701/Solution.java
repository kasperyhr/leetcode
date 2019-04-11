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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);
        
        TreeNode cursor = root;
        while(cursor.left != null && cursor.val > val ||
             cursor.right != null && cursor.val < val){
            if(cursor.val > val)
                cursor = cursor.left;
            else
                cursor = cursor.right;
        }
        
        if(cursor.val > val){
            cursor.left = new TreeNode(val);
        } else {
            cursor.right = new TreeNode(val);
        }
        
        return root;
    }
}