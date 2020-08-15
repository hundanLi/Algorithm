package problems.greedy;


/**
 * @author li
 * @version 1.0
 * @date 2019-05-18 10:41
 **/
public class MatrixScore {
    public static int matrixScore(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // 更新行使得最高位均等于1
        for (int[] row: matrix) {
            if (row[0] == 0) {
                for (int j = 0; j < n; j++) {
                    row[j] = 1 - row[j];
                }
            }
        }

        // 更新列使得每一列的1的个数最多，忽略第一列
        for (int i = 1; i < n; i++) {
            //统计1的个数
            int ones = 0;
            for (int[] row : matrix) {
                ones += row[i];
            }
            if (ones <= m / 2) {
                for (int[] row : matrix) {
                    row[i] = 1 - row[i];
                }
            }
        }

        // 求和
        int sum = 0;
        for (int[] row : matrix) {
            int exp = 0;
            while (exp < n) {
                sum += row[n - 1 - exp] * Math.pow(2, exp++);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1}, {1, 1}};
        int score = matrixScore(matrix);
        System.out.println(score);
        int pow = 0;
        pow += Math.pow(2, 4);
        System.out.println(pow);
    }
}
