package mock.month1909;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-24 09:35
 **/
public class SwimInWater {
    private static class Point {
        int x;
        int y;
        int height;

        Point(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }

    public int swimInWater(int[][] grid) {
        if (grid == null || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        PriorityQueue<Point> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.height));
        int i = 0;
        priorityQueue.offer(new Point(0, 0, grid[0][0]));
        boolean[][] visited = new boolean[grid.length][grid.length];
        visited[0][0] = true;
        while (true) {
            boolean finish = false;
            while (priorityQueue.size() > 0 && priorityQueue.element().height <= i) {
                Point point = priorityQueue.remove();
                int x = point.x;
                int y = point.y;
                if (x == grid.length - 1 && y == grid.length - 1) {
                    finish = true;
                    break;
                }
                if (x > 0 && !visited[x - 1][y]) {
                    visited[x - 1][y] = true;
                    priorityQueue.offer(new Point(x - 1, y, grid[x - 1][y]));
                }
                if (x < grid.length - 1 && !visited[x + 1][y]) {
                    visited[x + 1][y] = true;
                    priorityQueue.offer(new Point(x + 1, y, grid[x + 1][y]));
                }
                if (y > 0 && !visited[x][y - 1]) {
                    visited[x][y - 1] = true;
                    priorityQueue.offer(new Point(x, y - 1, grid[x][y - 1]));
                }
                if (y < grid.length - 1 && !visited[x][y + 1]) {
                    visited[x][y + 1] = true;
                    priorityQueue.offer(new Point(x, y + 1, grid[x][y + 1]));
                }
            }
            if (finish) {
                break;
            }
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {0, 2},
                {1, 3}
        };
        System.out.println(new SwimInWater().swimInWater(nums));
    }
}
