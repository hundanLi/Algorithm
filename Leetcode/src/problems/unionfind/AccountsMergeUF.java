package problems.unionfind;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-10 14:04
 **/
public class AccountsMergeUF {
    static class UnionFind {
        int[] parent;

        UnionFind(int size) {
            this.parent = new int[size + 1];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y) {
            parent[find(x)] = find(y);
        }

    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int emailNum = 0;
        for (List<String> account : accounts) {
            emailNum += (account.size() - 1);
        }
        UnionFind uf = new UnionFind(emailNum);
        Map<String, String> emailToName = new HashMap<>(16);
        Map<String, Integer> emailToId = new HashMap<>(16);
        int id = 0;
        for (List<String> account : accounts) {
            String name = "";
            for (String email : account) {
                if (Objects.equals(name, "")) {
                    name = email;
                    continue;
                }
                emailToName.put(email, name);
                if (!emailToId.containsKey(email)) {
                    emailToId.put(email, id++);
                }
                uf.union(emailToId.get(account.get(1)), emailToId.get(email));
            }
        }

        Map<Integer, List<String>> ans = new HashMap<>(16);
        for (String email : emailToName.keySet()) {
            int index = uf.find(emailToId.get(email));
            ans.computeIfAbsent(index, x -> new LinkedList<>()).add(email);
        }

        for (List<String> component : ans.values()) {
            Collections.sort(component);
            component.add(0, emailToName.get(component.get(0)));
        }
        return new ArrayList<>(ans.values());
    }

}

