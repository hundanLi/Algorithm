package problems.unionfind;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-09 11:08
 **/
public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts == null || accounts.size() == 0) {
            return Collections.emptyList();
        }
        Map<String, String> emailToName = new HashMap<>(16);
        Map<String, List<String>> graph = new HashMap<>(16);
        for (List<String> account : accounts) {
            String name = account.get(0);
            String email;
            for (int i = 1; i < account.size(); i++) {
                email = account.get(i);
                graph.computeIfAbsent(email, x-> new ArrayList<>()).add(account.get(1));
                graph.computeIfAbsent(account.get(1), x-> new ArrayList<>()).add(email);
                emailToName.put(email, name);
            }
        }

        Set<String> seen = new HashSet<>();

        List<List<String>> res = new LinkedList<>();
        Set<String> keySet = graph.keySet();
        for (String email : keySet) {
            if (!seen.contains(email)) {
                seen.add(email);
                Stack<String> stack = new Stack<>();
                stack.push(email);
                List<String> component = new LinkedList<>();
                while (stack.size() > 0) {
                    String poll = stack.pop();
                    component.add(poll);
                    for (String neighborEmail : graph.get(poll)) {
                        if (!seen.contains(neighborEmail)) {
                            seen.add(neighborEmail);
                            stack.push(neighborEmail);
                        }
                    }
                }
                Collections.sort(component);
                component.add(0, emailToName.get(email));
                res.add(component);
            }
        }
        return res;
    }

}
