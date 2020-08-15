package problems.hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-22 16:13
 **/
public class GetImportance {
    Map<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>(employees.size());
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return dfs(map.get(id));
    }

    private int dfs(Employee employee) {
        if (employee == null) {
            return 0;
        }
        int importance = employee.importance;
        for (Integer subId : employee.subordinates) {
            importance += dfs(map.get(subId));
        }
        return importance;
    }

    static class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    };
}
