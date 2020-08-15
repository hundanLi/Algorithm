package explore.datastructure.stack;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-04 09:55
 **/
public class NumIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int nums = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    nums++;
                    dfs(grid, i, j);
                }
            }
        }
        return nums;
    }

    private void dfs(char[][] grid, int x, int y) {
        grid[x][y] = '#';
        if (x < grid.length - 1 && grid[x + 1][y] == '1') {
            dfs(grid, x + 1, y);
        }
        if (y < grid[0].length - 1 && grid[x][y + 1] == '1') {
            dfs(grid, x, y + 1);
        }
        if (x > 0 && grid[x - 1][y] == '1') {
            dfs(grid, x - 1, y);
        }
        if (y > 0 && grid[x][y - 1] == '1') {
            dfs(grid, x, y - 1);
        }
    }
}
