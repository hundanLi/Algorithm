package explore.algorithm.senior.dp;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-08 16:41
 **/
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[][] paths = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    paths[i][j] = 1;
                    continue;
                }
                if (i == 0) {
                    paths[i][j] = paths[i][j - 1];
                } else if (j == 0) {
                    paths[i][j] = paths[i - 1][j];
                } else {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
        }
        return paths[m - 1][n - 1];
    }
}
