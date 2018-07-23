class MyLinkedList {
    class Node{
        int val;
        Node next;
        Node prev;
    }
    /** Initialize your data structure here. */
    Node head;
    Node tail;
    int size;
    public MyLinkedList() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        // p();
        if(size <= index)
            return -1;
        return getIndex(index).val;
    }
    
    private Node getIndex(int index){
        Node cursor = head;
        while(index >= 0){
            cursor = cursor.next;
            index --;
        }
        return cursor;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node n = new Node();
        n.val = val;
        n.next = head.next;
        n.next.prev = n;
        n.prev = head;
        head.next = n;
        size ++;
        // p();
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node n = new Node();
        n.val = val;
        n.next = tail;
        n.prev = tail.prev;
        tail.prev.next = n;
        tail.prev = n;
        size ++;
        // p();
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(size < index)
            return;
        Node n = new Node();
        n.val = val;
        Node cursor = getIndex(index);
        n.next = cursor;
        n.prev = cursor.prev;
        cursor.prev.next = n;
        cursor.prev = n;
        size ++;
        // p();
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(size <= index)
            return;
        Node cursor = getIndex(index);
        cursor.next.prev = cursor.prev;
        cursor.prev.next = cursor.next;
        size --;
        // p();
    }
    
    private void p(){
        Node cursor = head.next;
        while(cursor != tail){
            System.out.print(cursor.val + " ");
            cursor = cursor.next;
        }
        System.out.println();
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */