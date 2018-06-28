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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList();
        if(root == null)
            return ret;
        if(root.left == null && root.right == null){
            ret.add(Integer.toString(root.val));
            return ret;
        }
        List<String> tmp = new ArrayList();
        tmp.addAll(binaryTreePaths(root.left));
        tmp.addAll(binaryTreePaths(root.right));
        for(String sb: tmp){
            ret.add(root.val + "->" + sb);
        }
        return ret;
    }
}