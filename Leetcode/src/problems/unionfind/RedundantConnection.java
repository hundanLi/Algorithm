package problems.unionfind;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-08 09:08
 * 寻找无向图的环
 **/
public class RedundantConnection {
    private Set<Integer> seen = new HashSet<>();
    private int max = 1000;

    public int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges[0].length == 0) {
            return null;
        }
        ArrayList<Integer>[] graph = new ArrayList[max + 1];
        for (int i = 0; i <= max; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            seen.clear();
            if (!graph[edge[0]].isEmpty() && !graph[edge[1]].isEmpty()) {
                if (dfs(graph, edge[0], edge[1])) {
                    return edge;
                }
            }
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        return null;
    }

    private boolean dfs(ArrayList<Integer>[] graph, int source, int target) {
        if (!seen.contains(source)) {
            seen.add(source);
            if (source == target) {
                return true;
            }
            for (int neighbor : graph[source]) {
                if (dfs(graph, neighbor, target)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        int[] connection = new RedundantConnection().findRedundantConnection(edges);
        System.out.println(connection[0] + ", " + connection[1]);
    }
}
