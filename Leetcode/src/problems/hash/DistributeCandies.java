package problems.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-23 12:13
 **/
public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        int num = 0;
        int len = candies.length >> 1;
        for (int candy : candies) {
            if (!set.contains(candy)) {
                num++;
                if (num == len) {
                    break;
                }
                set.add(candy);
            }
        }
        return num;
    }
}
