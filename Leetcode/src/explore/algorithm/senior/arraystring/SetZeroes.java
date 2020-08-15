package explore.algorithm.senior.arraystring;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-24 21:03
 **/
public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        List<Coordinate> list = new ArrayList<>();
        int olen = matrix.length;
        int ilen = matrix[0].length;
        for (int i = 0; i < olen; i++) {
            for (int j = 0; j < ilen; j++) {
                if (matrix[i][j] == 0) {
                    list.add(new Coordinate(i, j));
                }
            }
        }
        for (Coordinate coordinate : list) {
            int x = coordinate.x;
            int y = coordinate.y;
            for (int i = 0; i < ilen; i++) {
                matrix[x][i] = 0;
            }
            for (int i = 0; i < olen; i++) {
                matrix[i][y] = 0;
            }
        }
    }

    class Coordinate{
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
