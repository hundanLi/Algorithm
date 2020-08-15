package problems.dynamic;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-23 14:28
 **/
public class WaysToChange {
    public int waysToChange(int n) {
        int[] coins = new int[]{1, 5, 10, 25};
        int[] ways = new int[n + 1];
        ways[0] = 1;
        for (int coin : coins) {
            for (int j = 0; j < n + 1; j++) {
                if (j >= coin) {
                    ways[j] += ways[j - coin];
                    ways[j] %= 1000000007;
                }
            }
        }
        return ways[n];
    }
}
