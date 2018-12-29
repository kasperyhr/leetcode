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
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> ret = new ArrayList<List<String>>();
        int d = depth(root);
        for(int i = 0; i < d; i++){
            List<String> l = new ArrayList<String>();
            for(int j = 0; j < (1 << d) - 1; j++){
                l.add("");
            }
            ret.add(l);
        }
        p(ret, 0, (1 << (d - 1)) - 1, d, root);
        return ret;
    }
    
    private int depth(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
    
    private void p(List<List<String>> ret, int row, int col, int d, TreeNode root){
        if(root == null)
            return;
        ret.get(row).set(col, Integer.toString(root.val));
        p(ret, row + 1, col - (1 << (d - row - 2)), d, root.left);
        p(ret, row + 1, col + (1 << (d - row - 2)), d, root.right);
    }
}