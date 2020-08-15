package mock.month1909;

import java.util.HashMap;
import java.util.Map;

/**
 * @author li
 * @version 1.0
 * @date 2019-09-16 11:25
 **/
public class CountTriplets {


    public int countTriplets(int[] nums) {
        int cnt = 0;
        Map<Integer, Integer> countMap = new HashMap<>(16);
        for (int n1 : nums) {
            for (int n2 : nums) {
                int and = n1 & n2;
                countMap.put(and, countMap.getOrDefault(and, 0) + 1);
            }
        }
        for (int m : countMap.keySet()) {
            if (m == 0) {
                cnt += countMap.get(m) * nums.length;
                continue;
            }
            for (int n : nums) {
                if ((n & m) == 0) {
                    cnt += countMap.get(m);
                }
            }
        }

        return cnt;
    }

    public int countTriplets2(int[] nums) {
        int cnt = 0;
        int[] map = new int[1 << 16];
        for (int n1 : nums) {
            for (int n2 : nums) {
                map[n1 & n2]++;
            }
        }
        for (int i = 0; i < map.length; i++) {

            if (i == 0) {
                cnt += map[i] * nums.length;
                continue;
            }
            if (map[i] == 0) {
                continue;
            }
            for (int n : nums) {
                if ((i & n) == 0) {
                    cnt += map[i];
                }
            }
        }
        return cnt;
    }
}