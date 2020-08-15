package problems.array;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-23 10:05
 **/
public class GenerateMatrix {
    public static int[][] generateMatrix(int n) {
        if (n <= 0) {
            return null;
        }
        int[][] ans = new int[n][n];
        int dx = 0;
        int dy = 1;
        int x = 0;
        int y = 0;
        int i = 1;
        while (i <= n * n) {
            ans[x][y] = i++;
            if (ans[(n + x + dx) % n][(n + y + dy) % n] > 0) {
                int temp = dx;
                dx = dy;
                dy = -temp;
            }
            x += dx;
            y += dy;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 1;
        int[][] matrix = generateMatrix(n);
        for (int[] nums : matrix) {
            for (int num : nums) {
                System.out.print(num + ", ");
            }
            System.out.println();
        }
    }
}
