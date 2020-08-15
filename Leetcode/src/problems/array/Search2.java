package problems.array;

import java.util.Arrays;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-23 13:29
 **/
public class Search2 {
    public static boolean search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target) >= 0;
    }

    private static int search(int[] nums, int fromIndex, int endIndex, int target) {
        if (fromIndex > endIndex) {
            return -1;
        }
        int mid = (fromIndex + endIndex) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            // 如果确定 nums[fromIndex] < target < nums[mid]，则使用二分查找
            if (nums[fromIndex] <= target) {
                return Arrays.binarySearch(nums, fromIndex, mid, target);
            }
        }
        int right = search(nums, mid + 1, endIndex, target);
        if (right >= 0) {
            return right;
        }
        return search(nums, fromIndex, mid - 1, target);
    }

}
