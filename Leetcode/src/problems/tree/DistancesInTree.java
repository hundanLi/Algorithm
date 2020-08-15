package problems.tree;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-16 00:26
 **/
public class DistancesInTree {
    private int[] counts;
    private int[] dists;
    private List<Set<Integer>> tree;
    private int n;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        if (n < 1) {
            return null;
        }
        this.n = n;
        tree = new ArrayList<>(n);
        dists = new int[n];
        counts = new int[n];
        for (int i = 0; i < n; i++) {
            counts[i] = 1;
            tree.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        dfs(0, -1);
        dfs2(0, -1);
        return dists;
    }

    private void dfs(int node, int parent) {
        for (int child : tree.get(node)) {
            if (child != parent) {
                dfs(child, node);
                counts[node] += counts[child];
                dists[node] += dists[child] + counts[child];
            }
        }
    }

    private void dfs2(int node, int parent) {
        for (int child : tree.get(node)) {
            if (child != parent) {
                dists[child] = dists[node] - counts[child] + (n - counts[child]);
                dfs2(child, node);
            }
        }
    }
}
