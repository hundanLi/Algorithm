package explore.algorithm.high.sortsearch;

import java.util.PriorityQueue;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-03 15:41
 * 思路：
 *  从右上角开始，如果 k > cols：
 *      dfs(matrix, row + 1, col, k-=cols)
 **/
public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            throw new RuntimeException("输入不合法！");
        }
        int n = matrix.length;
        PriorityQueue<Tuple> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            priorityQueue.offer(new Tuple(0, i, matrix[0][i]));
        }
        for (int i = 0; i < k - 1; i++) {
            Tuple t = priorityQueue.remove();
            if (t.x == n - 1) {
                continue;
            }
            priorityQueue.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
        }
        return priorityQueue.remove().val;
    }

    class Tuple implements Comparable<Tuple>{
        int x;
        int y;
        int val;

        Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple tuple) {
            return this.val - tuple.val;
        }
    }
}
