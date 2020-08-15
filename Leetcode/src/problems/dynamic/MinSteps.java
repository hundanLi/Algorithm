package problems.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2019-04-22 23:45
 **/
public class MinSteps {
    /**
     * 如果这个数是质数 则这个数只能一个一个的复制得到 操作步数就是这个数本身
     * 如果不是质数 则可以由复制得到 例如20可以由10复制得到 10可以由5复制得到
     * 而5是质数 只能一个一个复制 所以minStep （20） = 9
     */
    public int minSteps(int n) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                res += i;
                n /= i;
            }
        }
        return res;
    }
}
