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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[][] t = new List[n + 1][n + 1];
        return gen(1, n, t);
    }
    
    private List<TreeNode> gen(int start, int end, List<TreeNode>[][] t){
        List<TreeNode> ret = new ArrayList();
        if(start == 0 || end == 0)
            return ret;
        if(t[start - 1][end - 1] != null)
            return t[start - 1][end - 1];
        t[start - 1][end - 1] = ret;
        if(start > end){
            return ret;
        }
        for(int i = start; i <= end; i++){
            List<TreeNode> left = gen(start, i - 1, t);
            List<TreeNode> right = gen(i + 1, end, t);
            ret.addAll(gen2(left, right, i));
        }
        return ret;
    }
    
    private List<TreeNode> gen2(List<TreeNode> left, List<TreeNode> right, int val){
        List<TreeNode> ret = new ArrayList();
        if(left.size() == 0 && right.size() == 0){
            TreeNode root = new TreeNode(val);
            ret.add(root);
            return ret;
        }
        
        if(left.size() == 0){
            for(TreeNode tr: right){
                TreeNode root = new TreeNode(val);
                root.right = tr;
                ret.add(root);
            }
            return ret;
        }
        
        if(right.size() == 0){
            for(TreeNode tl: left){
                TreeNode root = new TreeNode(val);
                root.left = tl;
                ret.add(root);
            }
            return ret;
        }
        
        for(TreeNode tl: left){
            for(TreeNode tr: right){
                TreeNode root = new TreeNode(val);
                root.left = tl;
                root.right = tr;
                ret.add(root);
            }
        }
        return ret;
    }
}