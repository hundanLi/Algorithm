package explore.algorithm.high.treegragh;

import java.util.LinkedList;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-22 23:37
 **/
public class Solve {
    public void solve(char[][] board) {
        if (board == null || board.length <= 2 || board[0].length <= 2) {
            return;
        }
        List<Pair> pairs = new LinkedList<>();
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                if (dfs(pairs, board, i, j, visited)) {
                    for (Pair p : pairs) {
                        board[p.x][p.y] = 'X';
                    }
                }
                pairs.clear();
            }
        }

    }

    private boolean dfs(List<Pair> pairs, char[][] board, int r, int c, boolean[][] visited) {
        if (r == board.length || c == board[0].length || r < 0 || c < 0) {
            return true;
        }
        if (board[r][c] == 'O' && !visited[r][c]) {
            visited[r][c] = true;
            if (r == board.length - 1 || r == 0 || c == board[0].length - 1 || c == 0) {
                pairs.clear();
                //'O'不被'X'包围
                return false;
            }
            pairs.add(new Pair(r, c));
            boolean rp = dfs(pairs, board, r + 1, c, visited);
            boolean rm = dfs(pairs, board, r - 1, c, visited);
            boolean cp = dfs(pairs, board, r, c + 1, visited);
            boolean cm = dfs(pairs, board, r, c - 1, visited);
            return rp && rm && cp && cm;
        }
        return true;
    }

    private class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class Solution {
        public void solve(char[][] board) {
            if (board.length == 0) {
                return;
            }
            int m = board.length;
            int n = board[0].length;
            for (int i = 0; i < m; i++) {
                board = find(board, i, 0);
                board = find(board, i, n - 1);
            }
            for (int j = 1; j < n - 1; j++) {
                board = find(board, 0, j);
                board = find(board, m - 1, j);
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    } else if (board[i][j] == '$') {
                        board[i][j] = 'O';
                    }
                }
            }
        }

        public char[][] find(char[][] board, int i, int j) {
            if (i >= board.length || j >= board[0].length || i < 0 || j < 0) {
                return board;
            }
            if (board[i][j] == 'O') {
                board[i][j] = '$';
                board = find(board, i - 1, j);
                board = find(board, i + 1, j);
                board = find(board, i, j - 1);
                board = find(board, i, j + 1);
            }
            return board;
        }
    }

}

