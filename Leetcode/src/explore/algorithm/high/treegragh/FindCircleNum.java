package explore.algorithm.high.treegragh;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-23 21:38
 **/
public class FindCircleNum {
    public static int findCircleNum(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        boolean[] visited = new boolean[matrix.length];
        int cn = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (!visited[i]) {
                cn++;
                visited[i] = true;
                dfs(matrix, visited, i);
            }
        }
        return cn;
    }

    private static void dfs(int[][] matrix, boolean[] visited, int row) {
        for (int i = 0; i < visited.length; i++) {
            if (matrix[row][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(matrix, visited, i);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int circleNum = findCircleNum(matrix);
        System.out.println(circleNum);

    }

}
