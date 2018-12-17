/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val)
            head = head.next;
        if(head == null)
            return head;
        if(head.next == null){
            if(head.val == val)
                return null;
            else
                return head;
        }
        ListNode c = head;
        ListNode cn = head.next;
        while(cn != null){
            if(cn.val == val)
                c.next = cn.next;
            else
                c = c.next;
            cn = cn.next;
        }
        return head;
    }
}