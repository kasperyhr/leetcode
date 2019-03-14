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
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 1; i < preorder.length; i++){
            insert(root, preorder[i]);
        }
        return root;
    }
    
    private void insert(TreeNode root, int num){
        if(root.val < num){
            if(root.right == null){
                root.right = new TreeNode(num);
            } else{
                insert(root.right, num);        
            }        
        }
        else{
            if(root.left == null){
                root.left = new TreeNode(num);
            } else{
                insert(root.left, num);        
            }       
        }
    }
}