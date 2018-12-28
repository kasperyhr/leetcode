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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(t == null)
            return true;
        if(s == null)
            return false;
        if(isSubtree(s.left, t) || isSubtree(s.right, t))
            return true;
        return equal(s, t);
    }
    
    private boolean equal(TreeNode s, TreeNode t){
        if(s == null && t == null)
            return true;
        if(s == null || t == null)
            return false;
        if(s.val != t.val)
            return false;
        return equal(s.left, t.left) && equal(s.right, t.right);
    }
}