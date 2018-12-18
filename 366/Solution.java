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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        rec(root, ret);
        return ret;
    }
    private int rec(TreeNode root, List<List<Integer>> ret){
        if(root == null)
            return -1;
        else{
            int h = Math.max(rec(root.left, ret), rec(root.right, ret)) + 1;
            if(ret.size() <= h){
                ret.add(new LinkedList<Integer>());
            }
            ret.get(h).add(root.val);
            return h;
        }
    }
}