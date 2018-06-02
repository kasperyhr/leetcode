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
    public boolean hasCycle(ListNode head) {
        ListNode n1 = head;
        ListNode n2 = head;
        do{
            if(n2 == null)
                return false;
            if(n2.next == null)
                return false;
            n1 = n1.next;
            n2 = n2.next.next;
        } while(n1 != n2);
        return true;
    }
}
