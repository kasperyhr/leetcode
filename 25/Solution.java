/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1)
            return head;
        int l = getLen(head);
        if(l < k)
            return head;
        List<ListNode[]> ls = new ArrayList();
        for(int i = 0; i < l / k; i++){
            ListNode[] ln = reverse(head, k);
            ls.add(ln);
            head = ln[2];
        }
        ListNode ret = ls.get(0)[0];
        for(int i = 1; i < ls.size(); i++){
            ls.get(i - 1)[1].next = ls.get(i)[0];
        }
        ls.get(ls.size() - 1)[1].next = ls.get(ls.size() - 1)[2];
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
    
    private ListNode[] reverse(ListNode head, int len){
        ListNode tmp = head;
        while(len > 1){
            tmp = tmp.next;
            len = len - 1;
        }
        ListNode rest = tmp.next;
        tmp.next = null;
        ListNode[] ret = new ListNode[3];
        ret[0] = reverseList(head);
        ret[1] = head;
        ret[2] = rest;
        return ret;
    }
    
    private ListNode reverseList(ListNode head) {
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