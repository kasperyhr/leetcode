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
    public int sumOfLeftLeaves(TreeNode root) {
        return sumMyself(root, false);
    }
    
    public int sumMyself(TreeNode root, boolean isLeft){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null){
            if(isLeft)
                return root.val;
            else
                return 0;
        }
        
        int sum = 0;
        sum += sumMyself(root.left, true);
        sum += sumMyself(root.right, false);
        return sum;
    }
}