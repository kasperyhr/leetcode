/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        Node n = new Node(insertVal, null);
        if(head == null){
            n.next = n;
            return n;
        }
        if(head.next == head){
            n.next = head;
            head.next = n;
            return head;
        }
        Node cursor1 = head;
        Node cursor2 = head.next;
        while(cursor2 != head){
            if(cursor1.val <= n.val && n.val <= cursor2.val){
                cursor1.next = n;
                n.next = cursor2;
                return head;
            }
            if((cursor1.val <= n.val || n.val <= cursor2.val) && cursor2.val < cursor1.val){
                cursor1.next = n;
                n.next = cursor2;
                return head;
            }
            cursor1 = cursor1.next;
            cursor2 = cursor2.next;
        }
        cursor1.next = n;
        n.next = cursor2;
        return head;
    }
}