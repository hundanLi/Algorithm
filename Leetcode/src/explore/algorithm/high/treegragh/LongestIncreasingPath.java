package explore.algorithm.high.treegragh;



/**
 * @author li
 * @version 1.0
 * @date 2019-03-25 00:08
 **/
public class LongestIncreasingPath {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] maxLength = new int[matrix.length][matrix[0].length];
        int rs = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (maxLength[i][j] > 0) {
                    continue;
                }
                rs = Math.max(rs, dfs(matrix, maxLength, i, j));
            }
        }
        return rs;
    }

    private int dfs(int[][] matrix, int[][] maxLength, int x, int y) {
        if (maxLength[x][y] > 0) {
            return maxLength[x][y];
        }
        int ret = 1;
        if (x > 0 && matrix[x - 1][y] > matrix[x][y]) {
            ret = Math.max(ret, 1 + dfs(matrix, maxLength, x - 1, y));
        }
        if (x < matrix.length - 1 && matrix[x + 1][y] > matrix[x][y]) {
            ret = Math.max(ret, 1 + dfs(matrix, maxLength, x + 1, y));

        }
        if (y > 0 && matrix[x][y - 1] > matrix[x][y]) {
            ret = Math.max(ret, 1 + dfs(matrix, maxLength, x, y - 1));
        }
        if (y < matrix[0].length - 1 && matrix[x][y + 1] > matrix[x][y]) {
            ret = Math.max(ret, 1 + dfs(matrix, maxLength, x, y + 1));
        }
        maxLength[x][y] = ret;
        return ret;
    }

    public static void main(String[] args) {
        int[][] matrix =
                new int[][]{{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, {19, 18, 17, 16, 15, 14, 13, 12, 11, 10}, {20, 21, 22, 23, 24, 25, 26, 27, 28, 29}, {39, 38, 37, 36, 35, 34, 33, 32, 31, 30}, {40, 41, 42, 43, 44, 45, 46, 47, 48, 49}, {59, 58, 57, 56, 55, 54, 53, 52, 51, 50}, {60, 61, 62, 63, 64, 65, 66, 67, 68, 69}, {79, 78, 77, 76, 75, 74, 73, 72, 71, 70}, {80, 81, 82, 83, 84, 85, 86, 87, 88, 89}, {99, 98, 97, 96, 95, 94, 93, 92, 91, 90}, {100, 101, 102, 103, 104, 105, 106, 107, 108, 109}, {119, 118, 117, 116, 115, 114, 113, 112, 111, 110}, {120, 121, 122, 123, 124, 125, 126, 127, 128, 129}, {
                        139, 138, 137, 136, 135, 134, 133, 132, 131, 130}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        int increasingPath = new LongestIncreasingPath().longestIncreasingPath(matrix);
        System.out.println(increasingPath);
    }
}
