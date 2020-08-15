package problems.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-15 15:52
 **/
public class NumSquares {
    public int numSquares(int n) {
        int[] num = new int[n + 1];
        num[0] = 0;
        for (int i = 1; i <= n; i++) {
            int x = (int) Math.sqrt(i);
            num[i] = i;
            for (int j = 1; j <= x; j++) {
                num[i] = Math.min(num[i], 1 + num[i - j * j]);
            }
        }
        return num[n];
    }
}
