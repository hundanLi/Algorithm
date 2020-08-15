package explore.algorithm.high.arraystring;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-14 14:15
 **/
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] nextState = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int count = countLiving(board, row, col, rows - 1, cols - 1);
                if (board[row][col] == 1) {
                    if (count < 2) {
                        nextState[row][col] = false;
                    } else {
                        nextState[row][col] = count <= 3;
                    }
                } else {
                    if (count == 3) {
                        nextState[row][col] = true;
                    }
                }

            }
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (nextState[row][col]) {
                    board[row][col] = 1;
                } else {
                    board[row][col] = 0;
                }
            }
        }
    }

    private int countLiving(int[][] board, int row, int col, int rows, int cols) {
        int count = 0;
        //上一行
        if (row > 0) {
            int upRow = row - 1;
            for (int i = col - 1; i <= col + 1; i++) {
                if (i >=0 && i <=cols && board[upRow][i] == 1) {
                    count++;
                }
            }
        }

        //当前行
        for (int i = col - 1; i <= col + 1; i++) {
            if (i != col && i >=0 && i <=cols && board[row][i] == 1) {
                count++;
            }
        }

        //下一行
        if (row < rows) {
            int downRow = row + 1;
            for (int i = col - 1; i <= col + 1; i++) {
                if (i >= 0 && i <= cols && board[downRow][i] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

}
