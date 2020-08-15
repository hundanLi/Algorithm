package explore.datastructure.tree.bst;

import java.util.TreeSet;

/**
 * @author li
 * @version 1.0
 * @date 2019-06-20 11:03
 **/
public class AlmostDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (i > k) {
                treeSet.remove(nums[i - k - 1]);
            }
            Integer floor = treeSet.floor(nums[i]);
            if (floor != null && (long) nums[i] - (long) floor <= t) {
                return true;
            }
            Integer ceil = treeSet.ceiling(nums[i]);
            if (ceil != null && (long) ceil - (long) nums[i] <= t) {
                return true;
            }
            treeSet.add(nums[i]);
        }
        return false;
    }

    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            if (k <= 0) {
                return false;
            }
            int len = nums.length;
            int end = 1;
            int start = 0;
            while (start < len - 1) {
                if (start != end && Math.abs((long) nums[start] - nums[end]) <= t) {
                    return true;
                }

                if (end - start == k || len - 1 == end) {
                    start++;
                    if (t != 0) {
                        end = start + 1;
                    }
                } else {
                    end++;
                }
            }
            return false;
        }
    }
}
