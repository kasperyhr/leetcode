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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0)
            return null;
        int val = postorder[postorder.length - 1];
        int[] leftsubIn = leftpart(inorder, val);
        int[] rightsubIn = rightpart(inorder, val);
        int[] leftsubPost = new int[leftsubIn.length];
        int[] rightsubPost = new int[rightsubIn.length];
        System.arraycopy(postorder, 0, leftsubPost, 0, leftsubPost.length);
        System.arraycopy(postorder, leftsubPost.length, rightsubPost, 0, rightsubPost.length);
        TreeNode tleft = buildTree(leftsubIn, leftsubPost);
        TreeNode tright = buildTree(rightsubIn, rightsubPost);
        TreeNode ret = new TreeNode(val);
        ret.left = tleft;
        ret.right = tright;
        return ret;
    }
    
    public static int[] leftpart(int[] inorder, int val){
        int index = 0;
        while(index < inorder.length){
            if(inorder[index] == val)
                break;
            index++;
        }
        int[] ret = new int[index];
        for(int i = 0; i < index; i++){
            ret[i] = inorder[i];
        }
        return ret;
    }
    
    public static int[] rightpart(int[] inorder, int val){
        int index = 0;
        while(index < inorder.length){
            if(inorder[index] == val)
                break;
            index++;
        }
        int[] ret = new int[inorder.length - index - 1];
        for(int i = 0; i < ret.length; i++){
            ret[i] = inorder[index + i + 1];
        }
        return ret;
    }
    
}