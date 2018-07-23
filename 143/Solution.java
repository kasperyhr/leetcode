/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode l2 = slow.next;
        slow.next = null;
        l2 = reverse(l2);
        ListNode l1 = head;
        merge(l1, l2);
    }
    
    private ListNode reverse(ListNode n){
        ListNode tail = n.next;
        ListNode head = n;
        head.next = null;
        while(tail != null){
            ListNode temp = tail;
            tail = tail.next;
            temp.next =  head;
            head = temp;
        }
        return head;
    }
    
    private ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null && l2 == null)
            return null;
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode ret = l1;
        l1 = l1.next;
        ret.next = l2;
        l2 = l2.next;
        ret.next.next = merge(l1, l2);
        return ret;
    }
}