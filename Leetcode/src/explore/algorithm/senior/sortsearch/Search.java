package explore.algorithm.senior.sortsearch;

/**
 * @author li
 * @version 1.0
 * @date 2019-03-08 15:20
 **/
public class Search {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int minIndex = findMin(nums);
        int left = binarySearch(nums, 0, minIndex - 1, target);
        if (left != -1) {
            return left;
        }
        return binarySearch(nums, minIndex, nums.length - 1, target);
    }

    private int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int minIndex = left;
        while (nums[left] > nums[right]) {
            if (right - left == 1) {
                minIndex = right;
                break;
            }
            int mid = (right + left) / 2;
            if (nums[mid] > nums[left]) {
                left = mid;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            }
        }
        return minIndex;
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
