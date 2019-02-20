class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ret = new int[numCourses];
        // Map from node-degree to the nodes
        Map<Integer, Set<Integer>> edgeCnt = new HashMap<Integer, Set<Integer>>();
        // key is the current course, value is the prerequisites.
        Map<Integer, Set<Integer>> edges = new HashMap<Integer, Set<Integer>>();
        // key is the prerequisite course, the value is the course can be seleted.
        Map<Integer, Set<Integer>> rEdges = new HashMap<Integer, Set<Integer>>();
        // Set<Integer> processed = new HashSet<Integer>();
        int processedCnt = 0;
        //Init.
        for(int i = 0; i <= numCourses; i++) edgeCnt.put(i, new HashSet<Integer>());
        for(int i = 0; i < numCourses; i++){
            edges.put(i, new HashSet<Integer>());
            rEdges.put(i, new HashSet<Integer>());
            edgeCnt.get(0).add(i);
        }
        
        // Then we need to store the data.
        for(int i = 0; i < prerequisites.length; i++){
            edges.get(prerequisites[i][0]).add(prerequisites[i][1]);
            rEdges.get(prerequisites[i][1]).add(prerequisites[i][0]);
            int size = edges.get(prerequisites[i][0]).size();
            edgeCnt.get(size - 1).remove(prerequisites[i][0]);
            edgeCnt.get(size).add(prerequisites[i][0]);
        }
        
        // then we need to do the topological sort.
        while(edgeCnt.get(0).size() > 0){
            Iterator<Integer> it = edgeCnt.get(0).iterator();
            int course = it.next();
            edgeCnt.get(0).remove(course);
            // processed.add(course);
            ret[processedCnt++] = course;
            // processedCnt += 1;
            for(int nextCourse: rEdges.get(course)){
                edges.get(nextCourse).remove(course);
                int size = edges.get(nextCourse).size();
                edgeCnt.get(size + 1).remove(nextCourse);
                edgeCnt.get(size).add(nextCourse);
            }
        }
        // if(processed.size() < numCourses) return false;
        if(processedCnt < numCourses) return new int[0];
        // return true;
        return ret;
    }
}