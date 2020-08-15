package explore.bytedance.array;

/**
 * @author li
 * @version 1.0
 * @date 2019-07-09 10:57
 **/
public class AreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int num = dfs(grid, i, j, 0);
                    max = Math.max(max, num);
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int x, int y, int num) {
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
            if (grid[x][y] == 1) {
                grid[x][y] = -1;
                num++;
                num = dfs(grid, x + 1, y, num);
                num = dfs(grid, x - 1, y, num);
                num = dfs(grid, x, y + 1, num);
                num = dfs(grid, x, y - 1, num);
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1}, {1, 0}};
        AreaOfIsland island = new AreaOfIsland();
        System.out.println(island.maxAreaOfIsland(grid));
    }
}
