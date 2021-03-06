import java.util.*;
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> q1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> q2 = new LinkedList<TreeNode>();
        if(root == null)
            return ret;
        q1.add(root);
        while(true) {
            LinkedList<Integer> l = new LinkedList<Integer>();
            while(!q1.isEmpty()){
                TreeNode t = q1.removeFirst();
                if(t.left != null)
                    q2.addLast(t.left);
                if(t.right != null)
                    q2.addLast(t.right);
                l.addLast(t.val);
            }
            if(l.isEmpty())
                break;
            ret.add(l);
            q1 = q2;
            q2 = new LinkedList<TreeNode>();
        }
        return ret;
    }
}