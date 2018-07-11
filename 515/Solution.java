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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ret = new ArrayList();
        if(root == null)
            return ret;
        Queue<TreeNode> q = new ArrayDeque();
        Queue<TreeNode> qn = new ArrayDeque();
        qn.offer(root);
        
        while(qn.peek() != null){
            q = qn;
            qn = new ArrayDeque();
            int max = Integer.MIN_VALUE;
            while(q.peek() != null){
                TreeNode t = q.poll();
                max = Math.max(max, t.val);
                if(t.left != null)
                    qn.offer(t.left);
                if(t.right != null)
                    qn.offer(t.right);
            }
            ret.add(max);
        }
        return ret;
    }
}