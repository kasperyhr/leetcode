/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry){
        ListNode ret = new ListNode(0);
        if(carry == 0){
            if(l1 == null)
                return l2;
            if(l2 == null)
                return l1;
            int val = l1.val + l2.val;
            if(val > 9){
                ret.val = val - 10;
                ret.next = addTwoNumbers(l1.next, l2.next, 1);
            } else {
                ret.val = val;
                ret.next = addTwoNumbers(l1.next, l2.next, 0);
            }
        } else {
            if(l1 == null)
                return addTwoNumbers(new ListNode(1), l2, 0);
            if(l2 == null)
                return addTwoNumbers(l1, new ListNode(1), 0);
            int val = l1.val + l2.val + 1;
            if(val > 9){
                ret.val = val - 10;
                ret.next = addTwoNumbers(l1.next, l2.next, 1);
            } else {
                ret.val = val;
                ret.next = addTwoNumbers(l1.next, l2.next, 0);
            }
        }
        return ret;
    }
}