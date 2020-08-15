package explore.datastructure.array;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-14 09:49
 **/
public class DiagonalOrder {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 ||
                matrix[0] == null || matrix[0].length == 0) {
            return new int[0];
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = 0;
        int[] ans = new int[m * n];
        int i = 0;
        boolean up = true;
        while (i < m * n) {
            ans[i++] = matrix[x][y];
            if (up) {
                if (x > 0) {
                    if (y < n - 1) {
                        x -= 1;
                        y += 1;
                    } else {
                        x += 1;
                        up = false;
                    }
                } else {
                    up = false;
                    if (y < n - 1) {
                        y += 1;
                    } else {
                        x += 1;
                    }
                }
            } else {
                if (x < m - 1) {
                    if (y > 0) {
                        x += 1;
                        y -= 1;
                    } else {
                        x += 1;
                        up = true;
                    }
                } else {
                    up = true;
                    y += 1;
                }
            }
        }
        return ans;
    }
}
