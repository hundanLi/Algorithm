package mock.month1909;

import java.util.Arrays;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-03 09:42
 **/
public class CitySchedCost {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> {
            int diff1 = o1[1] - o1[0];
            int diff2 = o2[1] - o2[0];
            if (diff1 == diff2) {
                return o1[0] - o2[0];
            }
            return diff2 - diff1;
        });
        int sum = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            sum += costs[i][0];
        }
        for (int i = costs.length / 2; i < costs.length; i++) {
            sum += costs[i][1];
        }
        return sum;
    }
}
