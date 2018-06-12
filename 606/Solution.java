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
    public String tree2str(TreeNode t) {
        if(t == null)
            return "";
        String ret = "" + t.val;
        if(t.left == null && t.right == null)
            return ret;
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        ret += "(" + left + ")";
        if(!right.equals(""))
            ret += "(" + right + ")";
        return ret;
    }
}