package problems.graph;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-20 10:57
 **/
public class GardenNoAdj {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] color = new int[n];
        List<Set<Integer>> graph = new ArrayList<>(n + 1);
        graph.add(null);
        for (int i = 1; i <= n; i++) {
            graph.add(new HashSet<>());
        }
        for (int[] path : paths) {
            graph.get(path[0]).add(path[1]);
            graph.get(path[1]).add(path[0]);
        }
        Set<Integer> neighbors;
        boolean[] invalid;
        for (int i = 1; i <= n; i++) {
            invalid = new boolean[4];
            neighbors = graph.get(i);
            for (int nb : neighbors) {
                if (color[nb - 1] > 0) {
                    invalid[color[nb - 1] - 1] = true;
                }
            }
            for (int j = 0; j < invalid.length; j++) {
                if (!invalid[j]) {
                    color[i - 1] = j + 1;
                    break;
                }
            }
        }
        return color;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] paths = {{1, 2}, {2, 3}, {3, 1}};
        System.out.println(Arrays.toString(new GardenNoAdj().gardenNoAdj(n, paths)));
    }
}
