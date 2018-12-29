/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(root == null)
            return ret;
        Queue<Node> q1 = new LinkedList<Node>();
        Queue<Node> q2 = new LinkedList<Node>();
        q2.add(root);
        while(!q2.isEmpty()){
            q1 = q2;
            q2 = new LinkedList<Node>();
            List<Integer> l = new ArrayList<Integer>();
            while(!q1.isEmpty()){
                Node n = q1.remove();
                for(Node child: n.children) q2.add(child);
                l.add(n.val);
            }
            ret.add(l);
        }
        return ret;
    }
}