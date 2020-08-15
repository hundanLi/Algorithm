package problems.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-15 14:13
 **/
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        return maximalSquareOptimizeSpace(matrix);
    }

    private int maximalSquareNoOpt(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        //初始化第一行和第一列
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
            max = Math.max(max, dp[0][i]);
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            max = Math.max(max, dp[i][0]);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                if (matrix[i][j] == '1' && matrix[i - 1][j] == '1' && matrix[i][j - 1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }

    private int maximalSquareOptimizeSpace(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] pre = new int[n];
        int[] cur = new int[n];
        int max = 0;
        //初始化第一行和第一列
        for (int i = 0; i < n; i++) {
            pre[i] = matrix[0][i] == '1' ? 1 : 0;
            max = Math.max(max, pre[i]);
        }

        for (int i = 1; i < m; i++) {
            cur[0] = matrix[i][0] == '1' ? 1 : 0;
            max = Math.max(max, cur[0]);
            for (int j = 1; j < n; j++) {
                cur[j] = matrix[i][j] == '1' ? 1 : 0;
                if (matrix[i][j] == '1' && matrix[i - 1][j] == '1' && matrix[i][j - 1] == '1') {
                    cur[j] = 1 + Math.min(pre[j - 1], Math.min(pre[j], cur[j - 1]));
                }
                max = Math.max(max, cur[j]);
            }
            int[] tmp = pre;
            pre = cur;
            cur = tmp;
        }
        return max * max;
    }

}
