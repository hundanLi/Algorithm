package problems.array;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-26 10:50
 **/
public class FindMin2 {
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
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid] < nums[r]) {
                r = mid;
            } else if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                // 如果l,mid,r位置的元素都相等的话，无法确定最小值在哪个区间
                if (nums[mid] == nums[l]) {
                    return linearFind(nums);
                } else {
                    l = mid + 1;
                }
            }
        }
        return nums[l];
    }

    private int linearFind(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return nums[i + 1];
            }
        }
        return nums[0];
    }

    class Solution {
        public int findMin(int[] nums) {
            int lo = 0, hi = nums.length - 1;
            while (lo <= hi) {
                while (nums[lo] == nums[hi] && lo != hi) {
                    lo++;
                }
                if (nums[lo] <= nums[hi]) {
                    return nums[lo];
                }
                int mid = (lo + hi) >> 1;
                if (nums[mid] <= nums[hi]) {
                    hi = mid;
                } else if (nums[mid] >= nums[lo]) {
                    lo = mid + 1;
                }
            }
            return nums[0];
        }
    }
}
