package mock.month1907;

import java.util.HashMap;
import java.util.Map;

/**
 * @author li
 * @version 1.0
 * @date 2019-07-28 10:38
 **/
public class SingleNumber {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>(nums.length);
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (countMap.get(num) == 1) {
                return num;
            }
        }
        return 0;
    }
}
