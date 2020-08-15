package problems.array;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-26 10:23
 **/
public class FindMin {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException();
        }
        int length = nums.length;
        if (length == 1 || nums[0] < nums[length - 1]) {
            return nums[0];
        }
        int l = 0;
        int r = length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < nums[r]) {
                r = mid;
            }
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            }
        }
        return nums[l];
    }

    class Solution {
        public int findMin(int[] nums) {
            int lo = 0, hi = nums.length - 1;
            if (nums[lo] <= nums[hi]) {
                return nums[0];
            }
            while (lo <= hi) {
                int mid = (lo + hi) >> 1;
                if (nums[mid] > nums[mid + 1]) {
                    return nums[mid + 1];
                } else {
                    if (nums[mid] < nums[lo]) {
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
                }
            }
            return nums[0];
        }
    }
}
