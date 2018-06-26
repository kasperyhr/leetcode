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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList();
        if(root == null)
            return ret;
        Stack<TreeNode> qr = new Stack();
        Stack<TreeNode> qi = new Stack();
        qi.push(root);
        boolean left = false;
        while(!qi.empty()){
            qr = qi;
            qi = new Stack();
            left = !left;
            List<Integer> l = new ArrayList();
            while(!qr.empty()){
                TreeNode t = qr.pop();
                if(left){
                    if(t.left != null)
                        qi.push(t.left);
                    if(t.right != null)
                        qi.push(t.right);
                } else {
                    if(t.right != null)
                        qi.push(t.right);
                    if(t.left != null)
                        qi.push(t.left);
                }
                l.add(t.val);
            }
            ret.add(l);
        }
        return ret;
    }
}