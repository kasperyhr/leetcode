/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null)
            return head;
        ListNode odd = null;
        ListNode even = null;
        ListNode oddCursor = null;
        ListNode evenCursor = null;
        ListNode cursor = head;
        boolean flag = false;
        while(cursor != null){
            if(flag){
                if(even == null){
                    even = cursor;
                    evenCursor = cursor;
                } else {
                    evenCursor.next = cursor;
                    evenCursor = evenCursor.next;
                }
            } else {
                if(odd == null){
                    odd = cursor;
                    oddCursor = cursor;
                } else {
                    oddCursor.next = cursor;
                    oddCursor = oddCursor.next;
                }
            }
            flag = !flag;
            cursor = cursor.next;
        }
        oddCursor.next = even;
        if(evenCursor != null)
            evenCursor.next = null;
        return odd;
    }
}