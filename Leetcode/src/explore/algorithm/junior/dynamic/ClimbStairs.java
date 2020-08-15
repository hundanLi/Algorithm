package explore.algorithm.junior.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-02-20 22:00
 **/
public class ClimbStairs {
    public int climbStairs(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 1;
        ans[1] = 1;
        for (int i = 2; i <= n; i++) {
            ans[i] = ans[i - 1] + ans[i - 2];
        }
        return ans[n];
    }
}
