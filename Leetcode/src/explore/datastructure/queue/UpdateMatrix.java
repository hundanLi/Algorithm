package explore.datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-07 10:51
 **/
public class UpdateMatrix {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return matrix;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] ans = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    ans[i][j] = 0;
                } else {
                    queue.clear();
                    queue.offer(new int[]{i, j});
                    ans[i][j] = bfs(matrix, queue);
                }
            }
        }
        return ans;
    }

    private int bfs(int[][] matrix, Queue<int[]> queue) {
        int cnt = 0;
        int[] pos;
        int size;
        while (!queue.isEmpty()) {
            cnt++;
            size = queue.size();
            while (size-- > 0) {
                pos = queue.remove();
                int x = pos[0];
                int y = pos[1];
                if (x > 0) {
                    if (matrix[x - 1][y] != 0) {
                        queue.offer(new int[]{x - 1, y});
                    } else {
                        return cnt;
                    }
                }
                if (x < matrix.length - 1) {
                    if (matrix[x + 1][y] != 0) {
                        queue.offer(new int[]{x + 1, y});
                    } else {
                        return cnt;
                    }
                }
                if (y > 0) {
                    if (matrix[x][y - 1] != 0) {
                        queue.offer(new int[]{x, y - 1});
                    } else {
                        return cnt;
                    }
                }
                if (y < matrix[0].length - 1) {
                    if (matrix[x][y + 1] != 0) {
                        queue.offer(new int[]{x, y + 1});
                    }else {
                        return cnt;
                    }
                }
            }
        }
        throw new RuntimeException("输入有误！");
    }

}
