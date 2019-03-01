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
    int cnt = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(cnt >= k)
            return 0;
        if(root == null)
            return 0;
        int val = 0;
        if(root.left != null){
            val = kthSmallest(root.left, k);
            if(cnt >= k)
                return val;     
        }
        cnt++;
        if(cnt >= k)
            return root.val;
        if(root.right != null){
            val = kthSmallest(root.right, k - val);
            if(cnt >= k)
                return val;
        }
        return 0;
    }
}