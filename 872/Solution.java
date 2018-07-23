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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = leaf(root1);
        List<Integer> l2 = leaf(root2);
        if(l1.size() != l2.size())
            return false;
        for(int i = 0; i < l1.size(); i++){
            if(l1.get(i) != l2.get(i))
                return false;
        }
        return true;
    }
    
    private List<Integer> leaf(TreeNode root){
        List<Integer> l = new ArrayList();
        if(root == null)
            return l;
        if(root.left == null && root.right == null){
            l.add(root.val);
            return l;
        }
        l.addAll(leaf(root.left));
        l.addAll(leaf(root.right));
        return l;
    }
}