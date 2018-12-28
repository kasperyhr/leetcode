class Solution {
    public String findContestMatch(int n) {
        TreeNode root = new TreeNode(1);
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        q2.add(root);
        int v = 1;
        while(v < n){
            v *= 2;
            q1 = q2;
            q2 = new LinkedList<TreeNode>();
            while(!q1.isEmpty()){
                TreeNode tn = q1.remove();
                tn.left = new TreeNode(tn.val);
                q2.add(tn.left);
                tn.right = new TreeNode(v - tn.val + 1);
                q2.add(tn.right);
            }
        }
        return root.toString();
    }
}
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int v){
        val = v;
    }

    public String toString(){
        if(left == null)
            return "" + val;
        return "(" + left.toString() + "," + right.toString() + ")";
    }
}