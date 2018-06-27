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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> qi = new ArrayDeque();
        Queue<TreeNode> qr = new ArrayDeque();
        List<Integer> ret = new ArrayList();
        if(root == null)
            return ret;
        qi.offer(root);
        while(qi.peek() != null){
            qr = qi;
            qi = new ArrayDeque();
            TreeNode last = null;
            while(qr.peek() != null){
                last = qr.poll();
                if(last.left != null)
                    qi.offer(last.left);
                if(last.right != null)
                    qi.offer(last.right);
            }
            ret.add(last.val);
        }
        return ret;
    }
}