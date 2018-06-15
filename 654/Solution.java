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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0)
            return null;
        if(nums.length == 1)
            return new TreeNode(nums[0]);
        int maxIndex = 0;
        int maxValue = nums[0];
        for(int i = 1; i < nums.length; i++)
            if(nums[i] > maxValue){
                maxIndex = i;
                maxValue = nums[i];
            }
        int[] left = new int[maxIndex];
        int[] right = new int[nums.length - maxIndex - 1];
        System.arraycopy(nums, 0, left, 0, maxIndex);
        System.arraycopy(nums, maxIndex + 1, right, 0, right.length);
        TreeNode root = new TreeNode(maxValue);
        root.left = constructMaximumBinaryTree(left);
        root.right = constructMaximumBinaryTree(right);
        return root;
    }
}