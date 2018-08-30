/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int len = getLen(head);
        if(head == null)
            return head;
        if(k >= len)
            k = k % len;
        // System.out.println("k = " + k + " len = " + len);
        if(k == 0)
            return head;
        k = len - k;
        ListNode tmp = head;
        while(k > 1){
            k -= 1;
            tmp = tmp.next;
        }
        ListNode ret = tmp.next;
        tmp.next = null;
        ListNode cursor = ret;
        while(cursor.next != null)
            cursor = cursor.next;
        cursor.next = head;
        return ret;
    }
    
    private int getLen(ListNode head){
        int len = 0;
        ListNode cursor = head;
        while(cursor != null){
            len += 1;
            cursor = cursor.next;
        }
        return len;
    }

}