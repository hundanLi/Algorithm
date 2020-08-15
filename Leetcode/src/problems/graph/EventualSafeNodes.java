package problems.graph;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-19 19:10
 **/
public class EventualSafeNodes {
    private boolean[] visited;
    private int[] safe;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return Collections.emptyList();
        }
        int n = graph.length;
        safe = new int[n];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            if (dfs(graph, i)) {
                list.add(i);
            }
        }
        return list;
    }

    private boolean dfs(int[][] graph, int s) {
        if (safe[s] > 0) {
            // 1：安全；2：不安全；0：不确定
            return safe[s] == 1;
        }
        if (visited[s]) {
            safe[s] = 2;
            return false;
        } else {
            visited[s] = true;
        }
        for (int t : graph[s]) {
            if (!dfs(graph, t)) {
                safe[s] = 2;
                return false;
            }
        }
        safe[s] = 1;
        return true;
    }

    public List<Integer> eventualSafeNodes1(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return Collections.emptyList();
        }
        int n = graph.length;
        List<Set<Integer>> rgraph = new ArrayList<>(n);
        Queue<Integer> queue = new ArrayDeque<>();
        int[] inCount = new int[n];
        for (int i = 0; i < n; i++) {
            rgraph.add(new HashSet<>());
        }
        for (int i = 0; i < n; i++) {
            if (graph[i].length == 0) {
                queue.offer(i);
                continue;
            }
            inCount[i] = graph[i].length;
            for (int j : graph[i]) {
                rgraph.get(j).add(i);
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int s = queue.remove();
            list.add(s);
            for (int t : rgraph.get(s)) {
                if (inCount[t] > 0) {
                    inCount[t]--;
                }
                if (inCount[t] == 0) {
                    queue.offer(t);
                }
            }
        }
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        System.out.println(new EventualSafeNodes().eventualSafeNodes1(graph));
    }
}
