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
        if(head == null || head.next == null)
            return head;
        
        ListNode ret = head;
        ListNode cursor1 = head;
        ListNode cursor2 = head.next;
        while(cursor2 != null){
            while(cursor2 != null && cursor1.val == cursor2.val){
                cursor2 = cursor2.next;
            }
            ret.next = cursor2;
            ret = ret.next;
            cursor1 = cursor2;
            if(cursor2 == null)
                break;
            else
                cursor2 = cursor2.next;
        }
        return head;
        
    }
}