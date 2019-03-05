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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<Integer>();
        inorder(root, arr);
        return twoSum(arr, k);
    }
    
    private void inorder(TreeNode root, List<Integer> l){
        if(root == null)
            return;
        inorder(root.left, l);
        l.add(root.val);
        inorder(root.right, l);
    }
    
    private boolean twoSum(List<Integer> arr, int k){
        int l = 0;
        int r = arr.size() - 1;
        while(l < r){
            if(arr.get(l) + arr.get(r) < k) l++;
            else if(arr.get(l) + arr.get(r) > k) r--;
            else return true;
        }
        return false;
    }
}