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
    public List<Integer> postorder(Node root) {
        List<Integer> ret = new ArrayList<Integer>();
        if(root == null)
            return ret;
        for(Node child: root.children) ret.addAll(postorder(child));
        ret.add(root.val);
        return ret;
    }
}