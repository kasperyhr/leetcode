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
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }
    
    private int sum(TreeNode root, int num){
        if(root == null)
            return 0;
        int val = num * 10 + root.val;
        if(root.left == null && root.right == null)
            return val;
        if(root.left == null)
            return sum(root.right, val);
        if(root.right == null)
            return sum(root.left, val);
        return sum(root.left, val) + sum(root.right, val);
    }
}