/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode tail = head.next;
        ListNode ret = head;
        head.next = null;
        while(tail != null){
            ListNode temp = tail;
            tail = tail.next;
            temp.next =  ret;
            ret = temp;
        }
        return ret;
        
    }
}