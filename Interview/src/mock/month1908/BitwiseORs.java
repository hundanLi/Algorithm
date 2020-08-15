package mock.month1908;

import java.util.HashSet;
import java.util.Set;

/**
 * @author li
 * @version 1.0
 * @date 2019-08-05 09:00
 **/
public class BitwiseORs {
    public int subarrayBitwiseORs(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int ans = nums[i];
            for (int j = i; j < nums.length; j++) {
                ans = ans | nums[j];
                set.add(ans);
                if (ans == 0) {
                    break;
                }
            }
        }
        return set.size();
    }
}
