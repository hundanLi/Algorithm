package problems.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-05 00:17
 **/
public class UniquePaths {
    public int uniquePathsWithObstacles(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] paths = new int[m][n];
        //初始化第一行
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 1) {
                paths[0][i] = 0;
            } else {
                if (i > 0) {
                    paths[0][i] = paths[0][i - 1];
                } else {
                    paths[0][i] = 1;
                }
            }
        }
        //初始化第一列
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 1) {
                paths[i][0] = 0;
            } else {
                if (i > 0) {
                    paths[i][0] = paths[i - 1][0];
                } else {
                    paths[i][0] = 1;
                }
            }
        }
        //推导式
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    paths[i][j] = 0;
                } else {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
        }
        return paths[m - 1][n - 1];
    }

}
