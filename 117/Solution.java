/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
    if(root == null)
            return;
        root.next = null;
        Queue<TreeLinkNode> q = new ArrayDeque();
        Queue<TreeLinkNode> qn = new ArrayDeque();
        if(root.left != null)
            qn.offer(root.left);
        if(root.right != null)
            qn.offer(root.right);

        while(qn.peek() != null){
            q = qn;
            qn = new ArrayDeque();
            while(q.peek() != null){
                TreeLinkNode t = q.poll();
                t.next = q.peek();
                if(t.left != null)
                    qn.offer(t.left);
                if(t.right != null)
                    qn.offer(t.right);
            }
        }        
    }
}