package problems.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-20 14:08
 **/
public class MaxDistance {
    public int maxDistance(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        if (queue.isEmpty() || queue.size() == rows * cols) {
            return -1;
        }
        int[][] steps = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[] cur;
        int level = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                cur = queue.remove();
                for (int[] step : steps) {
                    int[] next = new int[2];
                    next[0] = cur[0] + step[0];
                    next[1] = cur[1] + step[1];
                    if (next[0] >= 0 && next[0] < rows && next[1] >= 0 && next[1] < cols) {
                        if (grid[next[0]][next[1]] == 0) {
                            grid[next[0]][next[1]] = 1;
                            queue.offer(next);
                        }
                    }
                }
            }
            level++;
        }
        return level;
    }

}
