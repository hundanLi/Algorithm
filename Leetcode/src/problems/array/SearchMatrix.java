package problems.array;

import java.util.Arrays;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-23 10:51
 **/
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int n = matrix[0].length - 1;
        for (int[] row : matrix) {
            if (target < row[0]) {
                break;
            }
            if (target > row[n]) {
                continue;
            }
            int search = Arrays.binarySearch(row, target);
            if (search >= 0) {
                return true;
            }
        }
        return false;
    }

}
