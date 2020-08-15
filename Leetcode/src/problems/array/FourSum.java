package problems.array;

import java.util.*;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-21 13:26
 **/
public class FourSum {
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            if (nums == null || nums.length < 4) {
                return Collections.emptyList();
            }
            Arrays.sort(nums);
            Set<List<Integer>> set = new HashSet<>();
            int sum;
            for (int i = 0; i < nums.length - 3; i++) {
                if (nums[i] > target && target > 0) {
                    break;
                }
                for (int j = i + 1; j < nums.length - 2; j++) {
                    int part = nums[i] + nums[j];
                    if (part > target && target > 0) {
                        break;
                    }
                    int l = j + 1;
                    int r = nums.length - 1;
                    while (l < r) {
                        sum = part + nums[l] + nums[r];
                        if (sum < target) {
                            l++;
                        } else if (sum > target) {
                            r--;
                        } else {
                            set.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                            l++;
                            r--;
                        }
                    }
                }
            }
            return new ArrayList<>(set);
        }
    }
}
