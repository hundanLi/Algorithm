package explore.algorithm.junior.array;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-11 20:49
 **/
public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[] present = new boolean[9];
        //判断行
        for (char[] line : board) {
            for (int j = 0; j < 9; j++) {
                present[j] = false;
            }
            for (char num : line) {
                if (num != '.') {
                    if (present[num - '1']) {
                        return false;
                    } else {
                        present[num - '1'] = true;
                    }
                }
            }
        }
        //判断列
        for (int col = 0; col < 9; col++) {
            for (int i = 0; i < 9; i++) {
                present[i] = false;
            }
            for (int i = 0; i < 9; i++) {
                char c = board[i][col];
                if (c != '.') {
                    if (present[c - '1']) {
                        return false;
                    } else {
                        present[c - '1'] = true;
                    }
                }
            }
        }

        //检查3X3宫格
        int rowStart = 0;
        int rowEnd = 2;
        int colStart;
        int colEnd;
        for (int i = 0; i < 9; i++) {
            if (i == 3 || i == 6) {
                rowStart += 3;
                rowEnd += 3;
            }
            if (i % 3 == 1) {
                colStart = 3;
                colEnd = 5;
            } else if (i % 3 == 2) {
                colStart = 6;
                colEnd = 8;
            } else {
                colStart = 0;
                colEnd = 2;
            }
            for (int j = 0; j < 9; j++) {
                present[j] = false;
            }
            for (int row = rowStart; row <= rowEnd; row++) {
                for (int col = colStart; col <= colEnd; col++) {
                    char c = board[row][col];
                    if (c != '.') {
                        if (present[c - '1']) {
                            return false;
                        } else {
                            present[c - '1'] = true;
                        }
                    }
                }
            }
        }
        return true;

    }
}
