package problems.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-10-27 13:21
 * 满足要求的根节点数最多为2
 **/
public class MinHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges == null || edges.length <= 1) {
            List<Integer> res = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                res.add(i);
            }
            return res;
        }
        List<List<Integer>> edgeList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            edgeList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            edgeList.get(edge[0]).add(edge[1]);
            edgeList.get(edge[1]).add(edge[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < edgeList.size(); i++) {
            if (edgeList.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        List<Integer> nextLeaves;
        List<Integer> neighbor;
        while (n > 2) {
            n -= leaves.size();
            nextLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                int l = edgeList.get(leaf).get(0);
                neighbor = edgeList.get(l);
                for (int i = 0; i < neighbor.size(); i++) {
                    if (neighbor.get(i) == leaf) {
                        neighbor.remove(i);
                        break;
                    }
                }
                if (neighbor.size() == 1) {
                    nextLeaves.add(l);
                }

            }
            leaves = nextLeaves;
        }
        return leaves;
    }
}
