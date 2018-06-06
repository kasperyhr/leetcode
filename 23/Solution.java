/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];
        // lists is even
        if(lists.length % 2 == 0){
            // lists is even
            ListNode[] rec = new ListNode[lists.length / 2];
            for(int i = 0; i < rec.length; i++){
                rec[i] = merge(lists[2 * i], lists[2 * i + 1]);
            }
            return mergeKLists(rec);
        } else {
            // lists is odd
            ListNode[] rec = new ListNode[lists.length / 2 + 1];
            for(int i = 0; i < rec.length - 1; i++){
                rec[i] = merge(lists[2 * i], lists[2 * i + 1]);
            }
            rec[rec.length - 1] = lists[lists.length - 1];
            return mergeKLists(rec);
        }
    }
    
    public ListNode merge(ListNode n1, ListNode n2){
        if(n1 == null)
            return n2;
        if(n2 == null)
            return n1;
        ListNode head;
        ListNode cursor;
        if(n1.val < n2.val){
            head = new ListNode(n1.val);
            n1 = n1.next;
        } else {
            head = new ListNode(n2.val);
            n2 = n2.next;
        }
        cursor = head;
        while(n1 != null || n2 != null){
            if(n1 == null){
                cursor.next = new ListNode(n2.val);
                n2 = n2.next;
                cursor = cursor.next;
            } else if(n2 == null){
                cursor.next = new ListNode(n1.val);
                n1 = n1.next;
                cursor = cursor.next;
            } else if(n1.val < n2.val){
                cursor.next = new ListNode(n1.val);
                n1 = n1.next;
                cursor = cursor.next;
            } else {
                cursor.next = new ListNode(n2.val);
                n2 = n2.next;
                cursor = cursor.next;
            }
        }
        return head;
    }
}