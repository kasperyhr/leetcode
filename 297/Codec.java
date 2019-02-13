/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    public static final String NULL = "null";
    public static final String SPLITTER = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return new StringBuffer().append(NULL).append(SPLITTER).toString();
        }
        StringBuffer sb = new StringBuffer();
        sb.append(root.val).append(SPLITTER).append(serialize(root.left)).append(serialize(root.right));
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> q = new ArrayDeque<String>();
        q.addAll(Arrays.asList(data.split(SPLITTER)));
        TreeNode ret = dq(q);
        return ret;
    }
    
    private TreeNode dq(Deque<String> q){
        String s = q.remove();
        if(s.equals(NULL)) return null;
        TreeNode ret = new TreeNode(Integer.parseInt(s));
        ret.left = dq(q);
        ret.right = dq(q);
        return ret;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));