package problems.hash;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-23 14:25
 **/
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int len = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0) {
                        len++;
                        if (m == 1) {
                            len++;
                        } else if (grid[i + 1][j] == 0) {
                            len++;
                        }
                    } else if (i == m - 1) {
                        len++;
                        if (grid[i - 1][j] == 0) {
                            len++;
                        }
                    } else {
                        if (grid[i - 1][j] == 0) {
                            len++;
                        }
                        if (grid[i + 1][j] == 0) {
                            len++;
                        }
                    }

                    if (j == 0) {
                        len++;
                        if (n == 1) {
                            len++;
                        } else if (grid[i][j + 1] == 0) {
                            len++;
                        }
                    } else if (j == n - 1) {
                        len++;
                        if (grid[i][j - 1] == 0) {
                            len++;
                        }
                    } else {
                        if (grid[i][j - 1] == 0) {
                            len++;
                        }
                        if (grid[i][j + 1] == 0) {
                            len++;
                        }
                    }
                }
            }
        }
        return len;
    }
}
