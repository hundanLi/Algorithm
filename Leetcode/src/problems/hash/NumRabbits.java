package problems.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author li
 * @version 1.0
 * @date 2019-11-22 10:52
 **/
public class NumRabbits {
    public int numRabbits(int[] ans) {
        Map<Integer, Integer> map = new HashMap<>(ans.length);
        int num = 0;
        for (int n : ans) {
            if (!map.containsKey(n) || map.get(n) == n + 1) {
                num += (n + 1);
                map.put(n, 1);
            } else {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
        }
        return num;
    }

    public int numRabbits2(int[] ans) {
        int[] map = new int[1000];
        int num = 0;
        for (int n : ans) {
            if (map[n] == 0 || map[n] == n + 1) {
                num += (n + 1);
                map[n] = 1;
            } else {
                map[n]++;
            }
        }
        return num;
    }

}
