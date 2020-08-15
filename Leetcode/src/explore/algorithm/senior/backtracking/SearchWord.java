package explore.algorithm.senior.backtracking;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-26 21:28
 **/
public class SearchWord {
    public static boolean exist(char[][] board, String word) {
        if (board == null || word == null || word.isEmpty()) {
            return false;
        }
        char[] chars = word.toCharArray();
        boolean[][] isUsed = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, isUsed, i, j, chars, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, boolean[][] isUsed, int row, int col, char[] word, int i) {
        if (i >= word.length) {
            return true;
        }
        if (row >= board.length || row < 0 || col >= board[0].length || col < 0) {
            return false;
        }
        if (!isUsed[row][col]) {
            if (board[row][col] == word[i]) {
                isUsed[row][col] = true;
                boolean rp = dfs(board, isUsed, row + 1, col, word, i + 1);
                boolean rm = dfs(board, isUsed, row - 1, col, word, i + 1);
                boolean cp = dfs(board, isUsed, row, col + 1, word, i + 1);
                boolean cm = dfs(board, isUsed, row, col - 1, word, i + 1);
                if (rp || rm || cp || cm) {
                    return true;
                } else {
                    isUsed[row][col] = false;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        char[][] chars =new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        String test ="ABCESEEEFS";
        boolean exist = exist(chars, test);
        System.out.println(exist);

    }
}
