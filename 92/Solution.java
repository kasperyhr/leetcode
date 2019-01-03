/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n)
            return head;
        if(m > 1){
            head.next = reverseBetween(head.next, m-1, n-1);
            return head;
        }
        ListNode cur = null;
        ListNode ret = null;
        while(n > 0){
            ListNode tmp = head.next;
            head.next = ret;
            ret = head;
            if (cur == null) cur = ret;
            head = tmp;
            n--;
        }
        cur.next = head;
        return ret;
    }
}