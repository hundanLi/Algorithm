package problems.dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-13 01:04
 **/
public class NumIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    bfs(grid, i, j);
                }
            }
        }
        return num;
    }

    private void dfs(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        if (i > 0 && grid[i - 1][j] == '1') {
            dfs(grid, i - 1, j);
        }
        if (i < grid.length - 1 && grid[i + 1][j] == '1') {
            dfs(grid, i + 1, j);
        }
        if (j > 0 && grid[i][j - 1] == '1') {
            dfs(grid, i, j - 1);
        }
        if (j < grid[i].length - 1 && grid[i][j + 1] == '1') {
            dfs(grid, i, j + 1);
        }
    }


    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        grid[i][j] = '0';
        queue.offer(new int[]{i, j});
        while (queue.size() > 0) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] ord = queue.remove();
                int x = ord[0];
                int y = ord[1];
                if (x > 0 && grid[x - 1][y] == '1') {
                    grid[x - 1][y] = '0';
                    queue.offer(new int[]{x - 1, y});
                }
                if (x < grid.length - 1 && grid[x + 1][y] == '1') {
                    grid[x + 1][y] = '0';
                    queue.offer(new int[]{x + 1, y});
                }
                if (y > 0 && grid[x][y - 1] == '1') {
                    grid[x][y - 1] = '0';
                    queue.offer(new int[]{x, y - 1});
                }
                if (y < grid[x].length - 1 && grid[x][y + 1] == '1') {
                    grid[x][y + 1] = '0';
                    queue.offer(new int[]{x, y + 1});
                }
            }
        }
    }

}
