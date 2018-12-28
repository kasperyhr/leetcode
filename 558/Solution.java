/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
class Solution {
    public Node intersect(Node quadTree1, Node quadTree2) {
        if(quadTree1 == null && quadTree2 == null)
            return null;
        if(quadTree1.isLeaf && quadTree1.val)
            return quadTree1;
        if(quadTree1.isLeaf)
            return quadTree2;
        if(quadTree2.isLeaf && quadTree2.val)
            return quadTree2;
        if(quadTree2.isLeaf)
            return quadTree1;
        Node n = new Node(false, false, intersect(quadTree1.topLeft, quadTree2.topLeft), intersect(quadTree1.topRight, quadTree2.topRight), intersect(quadTree1.bottomLeft, quadTree2.bottomLeft), intersect(quadTree1.bottomRight, quadTree2.bottomRight));
        if(n.topLeft.isLeaf && n.topLeft.val 
           &&n.topRight.isLeaf && n.topRight.val 
           &&n.bottomLeft.isLeaf && n.bottomLeft.val 
           &&n.bottomRight.isLeaf && n.bottomRight.val)
            n = new Node(true, true, null, null, null, null);
        else if(n.topLeft.isLeaf && !n.topLeft.val 
           &&n.topRight.isLeaf && !n.topRight.val 
           &&n.bottomLeft.isLeaf && !n.bottomLeft.val 
           &&n.bottomRight.isLeaf && !n.bottomRight.val)
            n = new Node(false, true, null, null, null, null);
        return n;
    }
}