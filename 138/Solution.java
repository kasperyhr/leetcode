/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    HashMap<Integer, RandomListNode> m = new HashMap();
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return null;
        if(m.containsKey(head.label))
            return m.get(head.label);
        RandomListNode ret = new RandomListNode(head.label);
        m.put(ret.label, ret);
        ret.next = copyRandomList(head.next);
        ret.random = copyRandomList(head.random);
        return ret;
    }
}