class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] ret = new double[queries.length];
        //First we need to construct the graph.
        Graph g = new Graph();
        for(int i = 0; i < equations.length; i++){
            g.addEdge(equations[i][0], equations[i][1], values[i]);
        }
        //Then we need to query the graph.
        for(int i = 0; i < queries.length; i++){
            ret[i] = g.query(queries[i][0], queries[i][1]);
        }
        return ret;
    }
    
    class Graph{
        Map<String, Node> nodes;
        Map<Node, Double> visited;
        public Graph(){
            nodes = new HashMap<String, Node>();
        }
        public void addEdge(String s1, String s2, double d){
            if(!nodes.containsKey(s1)){
                nodes.put(s1, new Node(s1));
            }
            if(!nodes.containsKey(s2)){
                nodes.put(s2, new Node(s2));
            }
            Node n1 = nodes.get(s1);
            Node n2 = nodes.get(s2);
            n1.addNeighbor(n2, d);
            n2.addNeighbor(n1, 1 / d);
        }
        public double query(String s1, String s2){
            double ndef = -1.0;
            double def = 1.0;
            if(!nodes.containsKey(s1)) return ndef;
            if(!nodes.containsKey(s2)) return ndef;
            
            clearVisitStatus();
            
            Node n1 = nodes.get(s1);
            Node n2 = nodes.get(s2);
            Queue<Node> q = new LinkedList<Node>();
            if(n1 == n2) return def;
            q.add(n1);
            visited.put(n1, def);
            while(!q.isEmpty()){
                Node n = q.poll();
                double val = visited.get(n);
                for(Node nn: n.getNeighbors()){
                    double update = val * n.get(nn);
                    if(visited.containsKey(nn)) continue;
                    if(nn == n2) return update;
                    visited.put(nn, update);
                    q.add(nn);
                }
            }
            return ndef;
        }
        
        private void clearVisitStatus(){
            visited = new HashMap<Node, Double>();
        }
    }
    
    class Node{
        String str;
        Map<Node, Double> neighbors;
        public Node(String str){
            this.str = str;
            neighbors = new HashMap<Node, Double>();
        }
        public void addNeighbor(Node n, double d){
            neighbors.put(n, d);
        }
        public Set<Node> getNeighbors(){
            return neighbors.keySet();
        }
        public double get(Node n){
            return neighbors.get(n);
        }
    }
}
