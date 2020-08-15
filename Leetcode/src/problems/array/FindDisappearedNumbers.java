package problems.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-29 10:41
 **/
public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        List<Integer> ans = new ArrayList<>(nums.length / 2);
        for (int i = 0; i < nums.length; i++) {
            int e = nums[i];
            if (e > 0 && e != i + 1) {
                if (nums[e - 1] != e) {
                    nums[i] = nums[e - 1];
                    nums[e - 1] = e;
                    i--;
                } else {
                    nums[i] = -1;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
