package problems.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-10 19:10
 * 思路：第i阶可以由
 *      1.第i-1阶爬一步到达
 *      2.第i-2阶爬两步到达
 *    所以第i阶有p[i] = p[i-1] + p[i-2]
 *    p[0] = 1
 *    p[1] = 1
 *    p[2] = 2
 *    实际上是斐波那契数列
 **/
public class ClimbStairs {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int step1 = 1;
        int step2 = 1;
        int step = 0;
        for (int i = 2; i <= n; i++) {
            step = step1 + step2;
            step1 = step2;
            step2 = step;
        }
        return step;
    }
}
