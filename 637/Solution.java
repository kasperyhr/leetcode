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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ret = new ArrayList();
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
            ret.add(getAvg(l));
            q1 = q2;
            q2 = new LinkedList<TreeNode>();
        }
        return ret;        
    }
    
    public static double getAvg(List<Integer> l){
        double sum = 0.0;
        for(int i: l)
            sum += i;
        sum /= l.size();
        return sum;
    }
}