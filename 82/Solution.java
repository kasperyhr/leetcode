/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ret = null;
        ListNode cursor = null;
        ListNode n1 = head;
        ListNode n2 = dup(n1);
        while(n2 != null){
            if(n1.val == n2.val){
                if(ret == null){
                    ret = n1;
                    cursor = n1;
                } else {
                    cursor.next = n1;
                    cursor = cursor.next;
                }
                n1 = n1.next;
            } else {
                n1 = n2;
            }
            n2 = dup(n1);
        }
        if(cursor != null)
            cursor.next = null;
        return ret;
    }
    
    public ListNode dup(ListNode head){
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        ListNode cursor = head.next;
        if(head.val != cursor.val)
            return head;
        while(cursor != null && cursor.val == head.val){
            cursor = cursor.next;
        }
        return cursor;
    }
}