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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> a = new ArrayList();
        List<List<Integer>> ret = new ArrayList();
        ps(root, sum, 0, a, ret);
        return ret;
    }
    
    private void ps(TreeNode root, int target, int currSum, List<Integer> path, List<List<Integer>> ret){
        if(root == null)
            return;
        path.add(root.val);
        currSum += root.val;
        if(root.left == null && root.right == null){
            if(target == currSum){
                ret.add(new ArrayList(path));
            }
        } else {
            ps(root.left, target, currSum, path, ret);
            ps(root.right, target, currSum, path, ret);
        }
        
        path.remove(path.size() - 1);
        currSum -= root.val;
    }
}