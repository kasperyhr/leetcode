/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode curA = headA;
        ListNode curB = headB;
        boolean flagA = false;
        boolean flagB = false;
        while(curA != curB){
            if(curB.next == null){
                if(!flagA){
                    curB = headA;
                    flagA = true;
                } else{
                    return null;
                }
            } else {
                curB = curB.next;
            }
            
            if(curA.next == null){
                if(!flagB){
                    curA = headB;
                    flagB = true;
                } else {
                    return null;
                }
            } else {
                curA = curA.next;
            }
        }
        return curA;
    }
}