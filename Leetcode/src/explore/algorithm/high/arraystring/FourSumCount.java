package explore.algorithm.high.arraystring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-13 21:36
 **/
public class FourSumCount {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for (int c : C) {
            for (int d : D) {
                int sum = 0 - c - d;
                if (map.containsKey(sum)) {
                    count += map.get(sum);
                }
            }
        }
        return count;
    }
}
