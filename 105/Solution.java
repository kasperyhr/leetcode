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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length == 0)
            return null;
        int val = preorder[0];
        int[] leftsubIn = leftpart(inorder, val);
        int[] rightsubIn = rightpart(inorder, val);
        int[] leftsubPre = new int[leftsubIn.length];
        int[] rightsubPre = new int[rightsubIn.length];
        System.arraycopy(preorder, 1, leftsubPre, 0, leftsubPre.length);
        System.arraycopy(preorder, leftsubPre.length + 1, rightsubPre, 0, rightsubPre.length);
        TreeNode tleft = buildTree(leftsubPre, leftsubIn);
        TreeNode tright = buildTree(rightsubPre, rightsubIn);
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