/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    Map<Integer, Employee> m;
    public int getImportance(List<Employee> employees, int id) {
        m = new HashMap<Integer, Employee>();
        for (int i = 0; i < employees.size(); i++) {
            m.put(employees.get(i).id, employees.get(i));
        }
        return dfs(id);
    }
    
    private int dfs(int id){
        int ret = m.get(id).importance;
        for(int sub: m.get(id).subordinates){
            ret += dfs(sub);
        }
        return ret;
    }
}