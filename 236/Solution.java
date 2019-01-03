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
    TreeNode sol;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        sol = null;
        dfs(root, p, q);
        return sol;
    }
    
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return false;
        int cnt = 0;
        if(dfs(root.left, p, q)) cnt++;
        if(dfs(root.right, p, q)) cnt++;
        if(root == p || root == q) cnt++;
        if(cnt >= 2) sol = root;
        return cnt > 0;
    }
}