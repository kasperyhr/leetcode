/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode tmpH = null;
        ListNode cursor = head;
        if(head == null)
            return null;
        while(cursor.next != null){
            if(cursor.val != 9) tmpH = cursor;
            cursor = cursor.next;
        }
        if(cursor.val != 9) tmpH = cursor;
        if(tmpH == null){
            tmpH = new ListNode(1);
            tmpH.next = head;
            while(head != null){
                head.val = 0;
                head = head.next;
            }
            return tmpH;
        }
        tmpH.val += 1;
        ListNode n = tmpH.next;
        while(n != null){
            n.val = 0;
            n = n.next;
        }
        return head;
    }
}