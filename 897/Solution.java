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
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ret = root;
        //System.out.println(root.val);
        if(root.left != null){
            ret = increasingBST(root.left);
            TreeNode cursor = ret;
            while(cursor.right != null)
                cursor = cursor.right;
            cursor.right = root;
        }
        root.left = null;
        if(root.right != null){
            root.right = increasingBST(root.right);
        }
        // p(ret);
        
        return ret;
    }
    
    private int[] printTree(TreeNode n){
        if(n == null){
            int[] a = {Integer.MIN_VALUE};
            return a;
        }
        int[] l = printTree(n.left);
        int[] r = printTree(n.right);
        int[] ret = new int[l.length + r.length + 1];
        System.arraycopy(l, 0, ret, 1, l.length);
        ret[0] = n.val;
        System.arraycopy(r, 0, ret, l.length + 1, r.length);
        return ret;
    }
    
    private void p(TreeNode n){
        int[] arr = printTree(n);
        for(int i: arr)
            System.out.print(i + " ");
        System.out.println();
    }
}