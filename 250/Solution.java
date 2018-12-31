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
    int cnt;
    public int countUnivalSubtrees(TreeNode root) {
        cnt = 0;
        helper(root);
        return cnt;
    }
    
    private boolean helper(TreeNode t){
        if(t == null)
            return true;
        boolean flag = true;
        if(t.left != null) flag = flag & helper(t.left) & (t.val == t.left.val);
        if(t.right != null) flag = flag & helper(t.right) & (t.val == t.right.val);
        if(flag) cnt++;
        return flag;
    }
}