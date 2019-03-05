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
    public int findTilt(TreeNode root) {
        return postOrder(root).tilt;
    }
    
    class ResultNode{
        int sum;
        int diff;
        int tilt;
    }
    
    private ResultNode postOrder(TreeNode root){
        ResultNode ret = new ResultNode();
        if(root == null)
            return ret;
        ResultNode l = postOrder(root.left);
        ResultNode r = postOrder(root.right);
        ret.sum = l.sum + r.sum + root.val;
        ret.diff = Math.abs(l.sum - r.sum);
        ret.tilt = ret.diff + l.tilt + r.tilt;
        return ret;
    }
}