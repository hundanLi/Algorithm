package problems.array;

import java.util.Arrays;

/**
 * @author li
 * @version 1.0
 * @date 2019-05-23 11:35
 **/
public class Search {
    public static int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
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
                int binarySearch = Arrays.binarySearch(nums, fromIndex, mid, target);
                return binarySearch >= 0 ? binarySearch : -1;
            }
        }
        int right = search(nums, mid + 1, endIndex, target);
        if (right >= 0) {
            return right;
        }
        return search(nums, fromIndex, mid - 1, target);
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
//        int[] nums = {5, 1, 3};
        int target = 5;
        int search = search(nums, target);
        System.out.println(search);
    }
}
