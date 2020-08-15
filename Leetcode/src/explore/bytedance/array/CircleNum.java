package explore.bytedance.array;

/**
 * @author li
 * @version 1.0
 * @date 2019-07-17 09:23
 **/
public class CircleNum {
    public int findCircleNum(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        boolean[] visited = new boolean[matrix.length];
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (!visited[i]) {
                count++;
                visited[i] = true;
                dfs(matrix, visited, i);
            }
        }
        return count;
    }

    private void dfs(int[][] matrix, boolean[] visited, int i) {

        for (int j = 0; j < matrix.length; j++) {
            if (matrix[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(matrix, visited, j);
            }
        }
    }
}