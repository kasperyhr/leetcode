/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode f = head;
        ListNode s = head;
        while(f != null && f.next != null){
            f = f.next.next;
            s = s.next;
        }
        if(f != null){
            s = s.next;
        }
        s = reverse(s);
        while(s != null){
            if(head.val != s.val)
                return false;
            s = s.next;
            head = head.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode s){
        ListNode ret = null;
        while(s != null){
            ListNode tmp = s.next;
            s.next = ret;
            ret = s;
            s = tmp;
        }
        return ret;
    }
}