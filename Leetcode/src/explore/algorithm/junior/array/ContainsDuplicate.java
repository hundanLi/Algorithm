package explore.algorithm.junior.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author li
 * @version 1.0
 * @date 18-8-11 上午10:31
 **/
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
