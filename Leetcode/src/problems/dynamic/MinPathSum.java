package problems.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-04 13:56
 * 思路：令pathSum[i][j] 表示到达matrix[i][j]的最小路径和，
 *      则pathSum[i][j] = min(pathSum[i-1][j], path[i][j-1]) + matrix[i][j]
 **/
public class MinPathSum {
    public int minPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] pathSum = new int[m][n];
        pathSum[0][0] = matrix[0][0];
        //初始化第一行和第一列
        for (int i = 1; i < n; i++) {
            pathSum[0][i] = pathSum[0][i - 1] + matrix[0][i];
        }
        for (int i = 1; i < m; i++) {
            pathSum[i][0] = pathSum[i - 1][0] + matrix[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                pathSum[i][j] = matrix[i][j] + Math.min(pathSum[i - 1][j], pathSum[i][j - 1]);
            }
        }
        return pathSum[m - 1][n - 1];
    }

    /** 因为只需要要用到当前行和上一行，所以只需要维护两个数组
     * @param matrix 矩阵
     * @return  最小路径
     */
    public int minPathSumOptimizeSpace(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] preRowSum = new int[n];
        int[] curRowSum = new int[n];
//        初始化第一行
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                preRowSum[i] = matrix[0][i];
            } else {
                preRowSum[i] = preRowSum[i - 1] + matrix[0][i];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    curRowSum[j] = preRowSum[j] + matrix[i][j];
                } else {
                    curRowSum[j] = matrix[i][j] + Math.min(curRowSum[j - 1], preRowSum[j]);
                }
            }
            preRowSum = curRowSum;
        }
        return preRowSum[n - 1];
    }
}
