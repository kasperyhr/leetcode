/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    
    List<TreeNode> nodes;
    TreeNode root;
    public BSTIterator(TreeNode root) {
        this.root = root;
        nodes = new LinkedList<TreeNode>();
        inorder(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !nodes.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if(hasNext())
            return nodes.remove(0).val;
        else
            return 0;
    }
    
    private void inorder(TreeNode root){
        if(root == null)
            return;
        if(root.left != null)
            inorder(root.left);
        nodes.add(root);
        if(root.right != null)
            inorder(root.right);
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */