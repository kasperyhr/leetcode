/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    HashMap<Integer, UndirectedGraphNode> m = new HashMap();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return null;
        if(m.containsKey(node.label))
            return m.get(node.label);
        UndirectedGraphNode ret = new UndirectedGraphNode(node.label);
        m.put(ret.label, ret);
        for(UndirectedGraphNode n: node.neighbors){
            ret.neighbors.add(cloneGraph(n));
        }
        return ret;
    }
}