package problems.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-19 18:22
 **/
public class TwoCitySchedCost {

    /**
     * 对于送去A地的人，如果把他们送去B地的代价应该尽可能高
     * 亦即使得cost[i][0] - cost[i][1]越小越好
     */
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(a -> (a[0] - a[1])));
        int cost = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            cost += costs[i][0];
        }
        for (int i = costs.length / 2; i < costs.length; i++) {
            cost += costs[i][1];
        }
        return cost;
    }

    class Solution {
        public int twoCitySchedCost(int[][] costs) {
            int res = 0, len = costs.length;
            int[] cz = new int[len];
            for (int i = 0; i < len; i++) {
                res += costs[i][0];
                cz[i] = costs[i][1] - costs[i][0];
            }
            Arrays.sort(cz);
            for (int i = 0; i < len / 2; i++)
                res += cz[i];
            return res;

        }
    }
}
