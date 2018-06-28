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
    public int pathSum(TreeNode root, int sum) {
        return notUse(root, sum);
    }
    
    private int notUse(TreeNode root, int sum){
        if(root == null)
            return 0;
        int cnt = 0;
        cnt += notUse(root.left, sum);
        cnt += notUse(root.right, sum);
        cnt += use(root, sum);
        return cnt;
    }
    
    private int use(TreeNode root, int sum){
        if(root == null)
            return 0;
        int cnt = 0;
        if(sum == root.val)
            cnt += 1;
        cnt += use(root.left, sum - root.val);
        cnt += use(root.right, sum - root.val);
        return cnt;
    }
}