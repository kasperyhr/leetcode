/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        if(head == null)
            return null;
        LinkedList<Node> l = new LinkedList<Node>();
        Node cursor = head;
        while(cursor.next != null || cursor.child != null){
            if(cursor.child != null){
                if(cursor.next != null){
                    l.add(cursor.next);
                }
                cursor.next = cursor.child;
                cursor.next.prev = cursor;
                cursor.child = null;
            }
            cursor = cursor.next;
        }
        while(l.size() > 0){
            Node n = l.removeLast();
            cursor.next = n;
            n.prev = cursor;
            cursor = cursor.next;
            while(cursor.next != null || cursor.child != null){
                if(cursor.child != null){
                    if(cursor.next != null){
                        l.add(cursor.next);
                    }
                    cursor.next = cursor.child;
                    cursor.next.prev = cursor;
                    cursor.child = null;
                }
                cursor = cursor.next;
            }
        }
        return head;
    }
}