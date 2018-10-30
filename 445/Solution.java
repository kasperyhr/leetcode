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
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        ListNode cursor = l1;
        while(cursor != null){
            s1.push(cursor.val);
            cursor = cursor.next;
        }
        cursor = l2;
        while(cursor != null){
            s2.push(cursor.val);
            cursor = cursor.next;
        }
        
        int sum = 0;
        ListNode ret = new ListNode(0);
        while(!s1.isEmpty() || !s2.isEmpty()){
            if(!s1.isEmpty())
                sum += s1.pop();
            if(!s2.isEmpty())
                sum += s2.pop();
            ret.val = sum % 10;
            ListNode ln = new ListNode(0);
            ln.next = ret;
            ret = ln;
            sum /= 10;
        }
        while(sum > 0){
            ret.val = sum % 10;
            ListNode ln = new ListNode(0);
            ln.next = ret;
            ret = ln;
            sum /= 10;
        }
        return ret.next;
    }
}