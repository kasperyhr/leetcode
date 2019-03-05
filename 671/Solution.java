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
    int first = Integer.MAX_VALUE;
    int second = Integer.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) return -1;
        if(univalue(root, root.val)) return -1;
        dfs(root);
        return second;
    }
    
    private boolean univalue(TreeNode root, int val){
        if(root == null)
            return true;
        if(root.val != val)
            return false;
        return univalue(root.left, val) && univalue(root.right, val);
    }
    
    private void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        dfs(root.right);
        if(root.val < first){
            second = first;
            first = root.val;
        } else if(root.val < second && root.val > first){
            second = root.val;
        }
    }
}