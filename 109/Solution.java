/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        int length = 0;
        ListNode cursor = head;
        while(cursor != null){
            cursor = cursor.next;
            length += 1;
        }
        return helper(head, length);
    }
    
    public static TreeNode helper(ListNode head, int length){
        if(length == 0)
            return null;
        if(length == 1)
            return new TreeNode(head.val);
        int mid = length / 2;
        ListNode cursor = head;
        int index = 0;
        while(index < mid){
            cursor = cursor.next;
            index += 1;
        }
        TreeNode ret = new TreeNode(cursor.val);
        ret.left = helper(head, mid);
        ret.right = helper(cursor.next, length - 1 - mid);
        return ret;
    }
}