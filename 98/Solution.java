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
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        if(root.left == null && root.right == null)
            return true;
        if(isValidBST(root.left) && isValidBST(root.right)){
            TreeNode l = root.left;
            while(l != null){
                if(l.val >= root.val)
                    return false;
                l = l.right;
            }
            TreeNode r = root.right;
            while(r != null){
                if(r.val <= root.val)
                    return false;
                r = r.left;
            }
        } else 
            return false;
        return true;
    }
}