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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null;
        int mid = nums.length / 2;
        int[] left = new int[mid];
        int[] right = new int[nums.length - mid - 1];
        System.arraycopy(nums, 0, left, 0, mid);
        System.arraycopy(nums, mid + 1, right, 0, right.length);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(left);
        root.right = sortedArrayToBST(right);
        return root;
    }
}