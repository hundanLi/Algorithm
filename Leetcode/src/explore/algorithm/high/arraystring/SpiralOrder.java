package explore.algorithm.high.arraystring;

import java.util.LinkedList;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-11 23:38
 **/
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;
        int total = rows * cols;
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};
        int row = 0;
        int col = 0;
        int di = 0;
        while (count++ < total) {
            list.add(matrix[row][col]);
            visited[row][col] = true;
            int nr = row + dr[di];
            int nc = col + dc[di];
            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc]) {
                row = nr;
                col = nc;
            } else {
                di = (di + 1) % 4;
                row += dr[di];
                col += dc[di];
            }
        }
        return list;
    }
}
