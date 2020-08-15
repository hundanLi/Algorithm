package problems.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-28 10:16
 **/
public class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        int x = 0;
        int countX = 0;
        int y = 0;
        int countY = 0;
        for (int n : nums) {
            if (n == x) {
                countX++;
            } else if ( n == y) {
                countY++;
            } else if (countX == 0) {
                x = n;
                countX++;
            } else if (countY == 0) {
                y = n;
                countY++;
            } else {
                countX--;
                countY--;
            }
        }
        countX = 0;
        countY = 0;
        for (int n : nums) {
            if (n == x) {
                countX++;
            } else if (n == y) {
                countY++;
            }
        }
        List<Integer> ans = new ArrayList<>(2);
        if (countX > nums.length / 3) {
            ans.add(x);
        }
        if (countY > nums.length / 3) {
            ans.add(y);
        }
        return ans;
    }
}
