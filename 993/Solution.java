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
    Map<Integer, Integer> depth;
    Map<Integer, TreeNode> parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        depth = new HashMap<Integer, Integer>();
        parent = new HashMap<Integer, TreeNode>();
        dfs(root, null);
        return depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y);
    }
    
    public void dfs(TreeNode curr, TreeNode para){
        if(curr != null){
            int dep = (para == null) ? 0 : depth.get(para.val);
            dep++;
            depth.put(curr.val, dep);
            parent.put(curr.val, para);
            dfs(curr.left, curr);
            dfs(curr.right, curr);
        }
    }
}