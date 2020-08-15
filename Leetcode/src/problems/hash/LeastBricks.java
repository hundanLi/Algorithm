package problems.hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-23 12:29
 **/
public class LeastBricks {
    public int leastBricks(List<List<Integer>> wall) {
        int n = wall.size();
        Map<Integer, Integer> map = new HashMap<>(16);
        for (List<Integer> list : wall) {
            int sum = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                Integer w = list.get(i);
                sum += w;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int max = 0;
        for (Integer count : map.values()) {
            max = Math.max(max, count);
        }
        return n - max;
    }
}
