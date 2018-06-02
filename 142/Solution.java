/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode n1 = head;
        ListNode n2 = head;
        do{
            if(n2 == null)
                return null;
            if(n2.next == null)
                return null;
            n1 = n1.next;
            n2 = n2.next.next;
        } while(n1 != n2);
        n1 = head;
        while(n1 != n2){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }
}