/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode l1 = head;
        ListNode l1Cursor = l1;
        ListNode l2 = head.next;
        ListNode l2Cursor = l2;
        ListNode cursor = l2.next;
        while(cursor != null){
            l1Cursor.next = cursor;
            cursor = cursor.next;
            l1Cursor = l1Cursor.next;
            ListNode temp = l2Cursor;
            l2Cursor = l1Cursor;
            l1Cursor = temp;
        }
        l1Cursor.next = null;
        l2Cursor.next = null;
        return mergeTwoLists(sortList(l1), sortList(l2));
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode head = null;
        ListNode cursor = null;
        while(l1 != null || l2 != null){
            if(l1 == null){
                cursor.next = l2;
                break;
            } else if (l2 == null){
                cursor.next = l1;
                break;
            } else {
                if(l1.val < l2.val){
                    if(head == null){
                        head = l1;
                        cursor = l1;
                        l1 = l1.next;
                    } else {
                        cursor.next = l1;
                        l1 = l1.next;
                        cursor = cursor.next;
                    }
                } else {
                    if(head == null){
                        head = l2;
                        cursor = l2;
                        l2 = l2.next;
                    } else {
                        cursor.next = l2;
                        l2 = l2.next;
                        cursor = cursor.next;
                    }
                }
            }
        }
        return head;
    }
}