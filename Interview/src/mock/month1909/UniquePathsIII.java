package mock.month1909;


/**
 * @author li
 * @version 1.0
 * @date 2019-09-04 09:15
 **/
public class UniquePathsIII {
    private int num = 0;
    private int pathLen = 2;

    public int uniquePathsIII(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int x = 0, y = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    pathLen++;
                } else if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
            }
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        dfs(grid, x, y, visited, 1);
        return num;

    }

    private void dfs(int[][] grid, int x, int y, boolean[][] visited, int len) {
        if (x < 0 || x >= grid.length) {
            return;
        }
        if (y < 0 || y >= grid[0].length) {
            return;
        }
        if (grid[x][y] == -1 || visited[x][y]) {
            return;
        }
        if (grid[x][y] == 2) {
            if (len == pathLen) {
                num++;
            }
            return;
        }
        visited[x][y] = true;
        dfs(grid, x + 1, y, visited, len + 1);
        dfs(grid, x, y + 1, visited, len + 1);
        dfs(grid, x - 1, y, visited, len + 1);
        dfs(grid, x, y - 1, visited, len + 1);
        visited[x][y] = false;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 0},
                {0, 0, 2}
        };
        System.out.println(new UniquePathsIII().uniquePathsIII(grid));
    }
}
