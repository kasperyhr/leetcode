/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class CBTInserter {
    List<TreeNode> l;
    TreeNode root;
    boolean isLeft = true;
    public CBTInserter(TreeNode root) {
        this.root = root;
        l = new LinkedList<TreeNode>();
        l.add(root);
        traverse();
    }
    
    public int insert(int v) {
        TreeNode t = l.get(0);
        int ret = t.val;
        TreeNode tn = new TreeNode(v);
        l.add(tn);
        if(isLeft){
            t.left = tn;
        } else {
            t.right = tn;
            l.remove(0);
        }
        isLeft = !isLeft;
        return ret;
    }
    
    public TreeNode get_root() {
        return root;
    }
    
    private void traverse(){
        while(true){
            TreeNode t = l.get(0);
            if(t.left != null){
                l.add(t.left);
                isLeft = !isLeft;
            } else {
                break;
            }
            if(t.right != null){
                l.add(t.right);
                isLeft = !isLeft;
                l.remove(0);
            } else {
                break;
            }
        }
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */