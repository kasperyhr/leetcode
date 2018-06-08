/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode low = null;
        ListNode high = null;
        ListNode lowCursor = null;
        ListNode highCursor = null;
        while(head != null){
            if(head.val < x){
                if(low == null){
                    low = new ListNode(head.val);
                    lowCursor = low;
                } else {
                    lowCursor.next = new ListNode(head.val);
                    lowCursor = lowCursor.next;
                }
            } else {
                if(high == null){
                    high = new ListNode(head.val);
                    highCursor = high;
                } else {
                    highCursor.next = new ListNode(head.val);
                    highCursor = highCursor.next;
                }
            }
            head = head.next;
        }
        if(low == null)
            return high;
        lowCursor.next = high;
        return low;
    }
}