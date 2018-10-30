/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n == 0)
            return head;
        ListNode lead = head;
        ListNode curr = head;
        while(n > 0){
            lead = lead.next;
            n--;
        }
        if(lead == null)
            return head.next;
        while(lead.next != null){
            lead = lead.next;
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }
}