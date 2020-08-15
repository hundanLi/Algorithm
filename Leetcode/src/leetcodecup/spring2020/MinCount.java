package leetcodecup.spring2020;

/**
 * @author li
 * @version 1.0
 * @date 2020-04-18 15:03
 **/
public class MinCount {
    public int minCount(int[] coins) {
        int times = 0;
        for (int coin : coins) {
            times += coin / 2;
            if (coin % 2 == 1) {
                times++;
            }
        }
        return times;
    }
}
