package problems.graph;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-19 16:59
 **/
public class Bipartite {
    private int[] tags;
    private int[][] graph;
    private boolean[] visited;
    private boolean ans = true;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        tags = new int[n];
        this.graph = graph;
        visited = new boolean[n];
        for (int i = 0; ans && i < n; i++) {
            dfs(i);
        }
        return ans;
    }

    private void dfs(int idx) {
        if (!ans || visited[idx]) {
            return;
        }
        visited[idx] = true;
        for (int nextIdx : graph[idx]) {
            if (!visited[nextIdx]) {
                tags[nextIdx] = 1 - tags[idx];
                dfs(nextIdx);
            } else {
                if (tags[nextIdx] != 1 - tags[idx]) {
                    ans = false;
                }
            }
        }
    }
}
